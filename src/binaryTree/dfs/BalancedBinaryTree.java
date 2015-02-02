package binaryTree.dfs;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiahan on 12/29/14.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = maxDepth(root.left);
        if (L == -1) return -1;
        int R = maxDepth(root.right);
        if (R == -1) return -1;
        if (Math.abs(L - R) <= 1) {
            return Math.max(L, R) + 1;
        }
        return -1;
    }
}
