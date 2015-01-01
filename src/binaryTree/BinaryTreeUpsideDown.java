package binaryTree;

/**
 * Created by jiahan on 1/1/15.
 */
public class BinaryTreeUpsideDown {

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        TreeNode parent = null;
        TreeNode parentRight = null;

        while (p != null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent;
    }

    public TreeNode UpsideDownBinaryTree2(TreeNode root) {
        return dfsBottomUp(root, null);
    }

    private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
        if (p == null) {
            return parent;
        }
        TreeNode root = dfsBottomUp(p.left, p);
        p.left = (parent == null) ? parent : parent.right;
        p.right = parent;
        return root;
    }
}
