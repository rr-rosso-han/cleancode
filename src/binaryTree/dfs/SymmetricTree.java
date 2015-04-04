package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

/**
 * Created by jiahan on 2/1/15.
 */
public class SymmetricTree {
    @Test
    public void isSymmetric() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.left = b;
        a.right = c;
        boolean t = isSymmetric(a);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            if (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSymmetricII(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (right.val != left.val) {
                return false;
            } else {
                if (left.left != null && right.right != null) {
                    stack.push(right.right);
                    stack.push(left.left);
                } else if (left.left != null || right.right != null) {
                    return false;
                }

                if (left.right != null && right.left != null) {
                    stack.push(right.left);
                    stack.push(left.right);
                } else if (left.right != null && right.left != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
