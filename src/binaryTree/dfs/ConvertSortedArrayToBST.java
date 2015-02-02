package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 12/29/14.
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, left, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, right);
        return root;
    }
}
