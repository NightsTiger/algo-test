package datastructure.binarytree;

/**
 * @author : dingwenqiang
 * @date : 2019/11/6 13:31
 */
public class BinaryTree {

    private Node tree;

    public Node find(int target) {
        Node p = tree;
        while (p != null) {
            if (p.data == target) {
                return p;
            } else if (p.data > target) {
                p = p.leftChild;
            } else {
                p = p.rightChild;
            }
        }
        return null;
    }

    //       1
    //    2     3
    //  4  5   6  7
    // 8 9 ...
    public void insert(int target) {
        if (tree == null) {
            tree = new Node(target);
            return;
        }
        Node temp = new Node(target);
        Node p = tree;
        while (p != null) {
            if (p.data >= target) {
                if (p.leftChild == null) {
                    p.leftChild = temp;
                    return;
                }
                p = p.leftChild;
            } else {
                if (p.rightChild == null) {
                    p.rightChild = temp;
                    return;
                }
                p = p.rightChild;
            }
        }
    }

    public Node delete(int data) {
        //todo
        return null;
    }


    private static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }
}
