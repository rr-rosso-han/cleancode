package binaryTree;

import org.junit.Test;

/**
 * Created by jiahan on 1/23/15.
 */
public class LowestCommonAncestor {

    @Test
    public void lowestCommonAncestor() {
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(7);
        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(20);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(10);
        TreeNode a7 = new TreeNode(11);
        TreeNode a8 = new TreeNode(9);
        TreeNode a9 = new TreeNode(4);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        a3.right = a8;
        a8.left = a9;

        TreeNode b = lowestCommonAncestor(a1, a8, a9);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        if (root.equals(a) || root.equals(b)) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, a, b);
        TreeNode r = lowestCommonAncestor(root.right, a, b);

        if (l != null && r != null) {
            return root;
        }

        if (l != null) {
            return l;
        }
        return r;
    }
}
