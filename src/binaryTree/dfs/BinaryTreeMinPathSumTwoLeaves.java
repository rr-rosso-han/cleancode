package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 1/23/15.
 */
public class BinaryTreeMinPathSumTwoLeaves {
    private int minSum = Integer.MAX_VALUE;
    public int minPathSum(TreeNode root) {
        findMin(root);
        //maxSum(root);
        return minSum;
    }

    private int findMin(TreeNode p) {
        if (p == null) {
            return 0;
        }

        int leftMin = findMin(p.left);
        int rightMin = findMin(p.right);

        int curr_sum = Math.min(leftMin + rightMin + p.val, Math.min(leftMin, rightMin));
        if (curr_sum < minSum) {
            minSum = curr_sum;
        }

        return Math.min(leftMin, rightMin) + p.val;
    }

}
