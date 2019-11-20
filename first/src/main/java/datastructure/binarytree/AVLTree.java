package datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : dingwenqiang
 * @date : 2019/11/7 10:29
 * @description : 平衡二叉树（也叫AVL树，根据发现这个数据结构的作者名字而来）
 * 是二叉查找树的升级，平衡二叉树可以为空树，
 * 当不为空树时，任意一个节点的平衡因子，也即该节点左子树的高度与右子树的高度差的绝对值，必须<=1
 * 针对插入新元素导致的不平衡，主要通过相应的旋转来解决
 * <p>
 * 最小失衡子树：在新插入的结点向上查找，以第一个平衡因子的绝对值超过 1 的结点为根的子树称为最小不平衡子树。
 * 也就是说，一棵失衡的树，是有可能有多棵子树同时失衡的。而这个时候，我们只要调整最小的不平衡子树，就能够将不平衡的树调整为平衡的树。
 * <p>
 * <p>
 * or: 平衡二叉树的失衡调整主要是通过旋转最小失衡子树来实现的。根据旋转的方向有两种处理方式，左旋 与 右旋 。
 * 1、左-左型：做右旋。
 * 2、右-右型：做左旋转。
 * 3、左-右型：先做左旋，后做右旋。
 * 4、右-左型：先做右旋，再做左旋。
 * 参考文档
 * @see <html>https://www.cnblogs.com/fivestudy/p/10340647.html</html>
 * processOn
 * @see <html>https://www.processon.com/diagraming/5dc37114e4b0c5553751aca6</html>
 */

public class AVLTree {
    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public int getHeight(Node n) {
        if (n != null) {
            return n.height;
        }
        return 0;
    }

    public int getBalance(Node n) {
        if (n != null) {
            return getHeight(n.left) - getHeight(n.right);
        }
        return 0;
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        //rotation
        x.right = y;
        y.left = T2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        //Rotation
        y.left = x;
        x.right = T2;
        //update height
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data > data) {
            node.left = insert(node.left, data);
        } else if (node.data < data) {
            node.right = insert(node.right, data);
        } else {
            return node;// 已经存在
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balDiff = getBalance(node);

        // 左倾斜，右旋
        if (balDiff > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // 右倾斜，左旋
        if (balDiff < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // 左倾斜，先左旋，再右旋
        if (balDiff > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 右倾斜，先右旋，再左旋
        if (balDiff < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            System.out.println("要删除的节点不存在");
            return null;
        } else if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {//叶子节点，或者只拥有一个孩子节点的处理逻辑是一样的
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                //到这一步说明删除的节点拥有2个孩子节点
                // 找到剩下左子树里面最大的节点，或者找到右子树里面最小的节点，这里使用的是前者
                // 使用最大值覆盖当前要被删除的节点的值
                node.data = retrieveData(node.left);
                //最后删除，在剩下左子树里面刚才被替换到最大值的节点
                node.left = delete(node.left, node.data);
            }
        }
        if (node == null)
            return null;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balDiff = getBalance(node);
        // 左倾斜，右旋
        if (balDiff > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // 右倾斜，左旋
        if (balDiff < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // 左倾斜，先左旋，再右旋
        if (balDiff > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 右倾斜，先右旋，再左旋
        if (balDiff < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private int retrieveData(Node p) {
        while (p.right != null) p = p.right;
        return p.data;
    }


    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.data);
            inorder(root.right);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node head = queue.poll();
                level.add(head.data);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Node root = null;
        AVLTree i = new AVLTree();
        testCase2(root, i);
    }


    private static void testCase1(Node root, AVLTree i) {
        root = i.insert(root, 1);
        root = i.insert(root, 2);
        root = i.insert(root, 3);
        root = i.insert(root, 4);
        root = i.insert(root, 5);
        root = i.insert(root, 6);
        root = i.insert(root, 7);
        root = i.insert(root, 8);
        i.levelOrder(root);
        root = i.delete(root, 5);
        i.levelOrder(root);
    }

    private static void testCase2(Node root, AVLTree i) {
        root = i.insert(root, 50);
        root = i.insert(root, 25);
        root = i.insert(root, 75);
        root = i.insert(root, 15);
        root = i.insert(root, 40);
        root = i.insert(root, 60);
        root = i.insert(root, 80);
        root = i.insert(root, 35);
        root = i.insert(root, 55);
        root = i.insert(root, 65);
        root = i.insert(root, 90);
        root = i.insert(root, 62);
        i.levelOrder(root);
        root = i.delete(root, 15);
        i.levelOrder(root);

    }

}
