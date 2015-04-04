package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/4/15.
 */
public class PathSum {
    @Test
    public void hasPathSum() {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(14);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        boolean r = hasPathSum(a, 26);
        assertEquals("failure - hasPathSum  of '26' not right", true, r);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        int[] pathSum = new int[1];
        boolean[] isPathSum = new boolean[1];
        pathSum[0] = root.val;
        hasPathSumHelper(root, sum, isPathSum, pathSum);
        return isPathSum[0];
    }

    private void hasPathSumHelper(TreeNode x,
                               int sum,
                               boolean[] isPathSum,
                               int[] pathSum) {
        if (isPathSum[0]) {
            return;
        }
        if (x.right == null && x.left == null) {
            if (pathSum[0] == sum) {
                isPathSum[0] = true;
                return;
            } else {
                return;
            }
        }

        if (x.left != null) {
            pathSum[0] += x.left.val;
            hasPathSumHelper(x.left, sum, isPathSum, pathSum);
            pathSum[0] -= x.left.val;
        }

        if (x.right != null) {
            pathSum[0] += x.right.val;
            hasPathSumHelper(x.right, sum, isPathSum, pathSum);
            pathSum[0] -= x.right.val;
        }
    }
}
