package DivideandConquer;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 2/9/15.
 */
public class BinaryTreeMaximumPathSum {
    class Result {
        int singleSum;
        int maxSum;
        public Result(int s, int m) {
            maxSum = m;
            singleSum = s;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = findMaxSum(root);
        return res.maxSum;
    }

    private Result findMaxSum(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MIN_VALUE);
        }
        Result left = findMaxSum(node.left);
        Result right = findMaxSum(node.right);

        int singleSum = Math.max(left.singleSum, right.singleSum) + node.val;
        singleSum = Math.max(singleSum, 0);

        int maxSum = Math.max(left.maxSum, right.maxSum);
        maxSum = Math.max(left.singleSum + right.singleSum + node.val, maxSum);

        return new Result(singleSum, maxSum);
    }
}
