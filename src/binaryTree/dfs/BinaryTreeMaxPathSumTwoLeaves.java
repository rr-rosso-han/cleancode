package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 1/23/15.
 */
public class BinaryTreeMaxPathSumTwoLeaves {

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        //maxSum(root);
        return maxSum;
    }

    private int findMax(TreeNode p) {
        if (p == null) {
            return 0;
        }

        int leftMax = findMax(p.left);
        int rightMax = findMax(p.right);

        int curr_sum = Math.max(leftMax + rightMax + p.val, Math.max(leftMax, rightMax));
        if (curr_sum > maxSum) {
            maxSum = curr_sum;
        }
        //need to get leaf to leaf, cannot remove nagetive value and return 0;
        return Math.max(leftMax, rightMax) + p.val;
    }

}
