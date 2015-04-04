package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jiahan on 1/24/15.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversalHelper(result, root);
        return result;
    }
    private void preorderTraversalHelper(List<Integer> result, TreeNode x) {
        if (x == null) {
            return;
        }
        result.add(x.val);
        preorderTraversalHelper(result, x.left);
        preorderTraversalHelper(result, x.right);
        return;
    }
    @Test
    public void preorderTraversalStack() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        List<Integer> r = preorderTraversalStack(a1);
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        stack.add(curr);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.right != null) {
                stack.add(tmp.right);
            }
            if (tmp.left != null) {
                stack.add(tmp.left);
            }
        }
        return result;
    }
}
