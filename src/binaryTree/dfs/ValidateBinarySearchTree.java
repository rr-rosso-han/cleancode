package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 12/24/14.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode node, int low, int high) {
        if (node == null) {
            return true;
        }
        if (node.val > low && node.val < high) {
            return valid(node.left, low, node.val)
                    && valid(node.right, node.val, high);
        }
        return false;
    }
    private TreeNode prev;
    public boolean isValidBST2(TreeNode root) {
        prev = null;
        return isIncreasing(root);
    }

    private boolean isIncreasing(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (isIncreasing(node.left)) {
            if (prev != null && prev.val >= node.val) {
                return false;
            }
            prev = node;
            return isIncreasing(node.right);
        }
        return false;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public boolean isValidBST3(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return true;
        }
        if ((left == null || left < node.val) && (right == null || right > node.val)) {
            return valid(node.left, left, (Integer)node.val)
                    && valid(node.right, (Integer)node.val, right);
        }
        return false;
    }
}
