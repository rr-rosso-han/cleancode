package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by jiahan on 2/5/15.
 */
public class RecoverBinarySearchTree {
    TreeNode prev = null;
    TreeNode wrongNode1 = null;
    TreeNode wrongNode2 = null;
    @Test
    public void recoverTree() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        a.left = b;
        recoverTree(a);
        return;
    }
    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    if (prev != null) {
                        if (prev.val > current.val) {
                            if (wrongNode1 == null) {
                                wrongNode1 = prev;
                                wrongNode2 = current;
                            } else {
                                wrongNode2 = current;
                                break;
                            }
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }

        int tmp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = tmp;
    }
}
