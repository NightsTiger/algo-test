package datastructure.binarytree.traveral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : dingwenqiang
 * @date : 2019/10/23 23:46
 */
public class BinaryTreeTraveralDemo {
    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode rootNode = createBinaryNode(inputList);
        System.out.println("前序遍历：");
        preOrderTraveral(rootNode);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraveral(rootNode);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraveral(rootNode);
        System.out.println();

        System.out.println("层序遍历：");
        levelOrderTraversal(rootNode);
}

    /**
     * 创建一个二叉树
     *
     * @param inputList
     * @return
     */
    private static TreeNode createBinaryNode(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryNode(inputList);
            node.rightChild = createBinaryNode(inputList);
            return node;
        }
        return null;
    }

    private static class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**todo ---------------------------------------------广度优先-------------------------------------------------------*/

    private static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();
            //打印
            System.out.print(node.data + ",");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    /**todo ---------------------------------------------深度优先-------------------------------------------------------*/

    /**
     * 前序遍历
     *
     * @param node
     */
    private static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ",");
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data + ",");
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.data + ",");
    }
}
