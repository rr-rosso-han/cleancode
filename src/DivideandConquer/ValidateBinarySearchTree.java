package DivideandConquer;

import binaryTree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/9/15.
 */
public class ValidateBinarySearchTree {


    @Test
    public void test() {
        TreeNode aa = new TreeNode(2147483647);
        boolean p = isValidBST(aa);
        assertEquals("failure - isValid of 'aa' not right", true, p);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(30);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(45);
        a.right = b;
        b.left = c;
        c.right = d;
        d.right = e;
        boolean r = isValidBST(a);
        assertEquals("failure - isValid of 'a' not right", false, r);
    }

    class ResultWrapper {
        boolean isValid;
        public ResultWrapper(boolean flag) {
            isValid = flag;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ResultWrapper res = isValidBSTHelper(root, null, null);
        return res.isValid;
    }

    private ResultWrapper isValidBSTHelper(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return new ResultWrapper(true);
        }

        ResultWrapper leftNode = isValidBSTHelper(node.left, left, (Integer)node.val);
        ResultWrapper rightNode = isValidBSTHelper(node.right, (Integer)node.val, right);
        boolean flag = false;
        if (leftNode.isValid && rightNode.isValid) {
            if ((left == null || node.val > left) && (right == null || node.val < right)) {
                flag = true;
            }
        }
        return new ResultWrapper(flag);
    }
}