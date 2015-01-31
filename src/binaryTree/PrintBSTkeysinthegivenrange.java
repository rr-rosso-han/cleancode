package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/30/15.
 */
public class PrintBSTkeysInTheGivenRange {
    @Test
    public void print() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(1);

        a3.left = a4;
        a4.left = a5;
        a3.right = a1;
        a1.left = a2;

        int k1 = 1;
        int k2 = 4;
        List<Integer> r = print(a3, k1, k2);
    }
    public List<Integer> print(TreeNode root, int k1, int k2) {
        if (k1 > k2) {
            return print(root, k2, k1);
        }
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inOrderTraversal(result, root, k1, k2);
        return result;
    }

    private void inOrderTraversal(List<Integer> result,
                                  TreeNode node,
                                  int k1,
                                  int k2) {
        if (node == null) return;
        inOrderTraversal(result, node.left, k1, k2);
        if (k1 <= node.val && node.val <= k2) {
            result.add(node.val);
        }
        inOrderTraversal(result, node.right, k1, k2);
    }
}
