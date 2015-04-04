package binaryTree;

/**
 * Created by jiahan on 1/31/15.
 */
public class DeleteNodeinBinarySearchTree {
    private TreeNode root;

    public DeleteNodeinBinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode min() {
        if (root == null) return null;
        return min(root);
    }

    private TreeNode min(TreeNode x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private TreeNode deleteMin(TreeNode x) {
        if (x == null) {
            return null;
        }
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public TreeNode delete(int value) {
        return delete(root, value);
    }

    private TreeNode delete(TreeNode x, int value) {
        if (x == null) {
            return null;
        }
        if (x.val > value) {
            return delete(x.left, value);
        } else if (x.val < value) {
            return delete(x.right, value);
        } else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            TreeNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }
}
