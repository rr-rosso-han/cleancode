package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 1/1/15.
 */
public class BinaryTreeMaximumPathSum<E> {

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode<E> root) {
        findMax(root);
        //maxSum(root);
        return maxSum;
    }

    private int findMax(TreeNode p) {
        if (p == null) {
            return 0;
        }

        int left = findMax(p.left);
        int right = findMax(p.right);

        maxSum = Math.max(p.val + left + right, maxSum);
        int ret = p.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }

    private int maxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int  value  = root.val;
        int  lmax = 0;
        int  rmax = 0;
        if(root.left != null) {
            lmax = maxSum(root.left);
            if(lmax > 0) {
                value += lmax;
            }
        }

        if(root.right != null) {
            rmax = maxSum(root.right);
            if(rmax > 0) {
                value += rmax;
            }
        }

        //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}
        if (value > maxSum) {
            maxSum = value;
        }

        //return max of (root.val, root.val + lmax, root.val + rmax)
        return Math.max(root.val, Math.max(root.val + lmax, root.val + rmax));
    }
}
