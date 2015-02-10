package DivideandConquer;

import binaryTree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/9/15.
 */
public class BalancedBinaryTree {

    @Test
    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.right = c;
        boolean r = isBalanced(a);
        assertEquals("failure - isBalanced of 'a' not right", false, r);
    }
    class ResultWrapper {
        boolean isBalance;
        int depth;
        public ResultWrapper(boolean flag, int d) {
            isBalance = flag;
            depth = d;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedHelper(root).isBalance;
    }

    private ResultWrapper isBalancedHelper(TreeNode node) {

        if (node == null) {
            return new ResultWrapper(true, 0);
        }

        ResultWrapper left = isBalancedHelper(node.left);
        ResultWrapper right = isBalancedHelper(node.right);
        if (!left.isBalance || !right.isBalance || Math.abs(left.depth - right.depth) > 1) {
            return new ResultWrapper(false, Math.max(left.depth, right.depth) + 1);
        }
        return new ResultWrapper(true, Math.max(left.depth, right.depth) + 1);
    }
}
