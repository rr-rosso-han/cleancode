package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

/**
 * Created by jiahan on 2/3/15.
 */
public class FlattenBinaryTreetoLinkedList {

    @Test
    public void flatten() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        b.left = c;
        b.right = d;
        c.left = e;

        flatten(a);
        return;
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        TreeNode tail = null;
        while (current != null) {
            if (current.left != null) {
                TreeNode tmp = current.right;
                current.right = current.left;
                current.left = null;
                tail = current;
                while (tail.right != null) {
                    tail = tail.right;
                }
                tail.right = tmp;
            }
            current = current.right;
        }
        return;
    }
}
