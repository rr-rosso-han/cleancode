package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jiahan on 2/3/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    @Test
    public void buildTree() {
        int[] a = {1,2};
        int[] b = {2,1};
        TreeNode x = buildTree(a, b);
        return;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1 && inorder.length == 1) {
            if (preorder[0] == inorder[0]) {
                return root;
            } else {
                return null;
            }
        }
        int rootVal = preorder[0];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) return null;
        int leftSize = rootIndex;
        int rightSize = inorder.length - rootIndex - 1;


        if (leftSize > 0) {
            int[] newPreLeft = new int[leftSize];
            int[] newInLeft = new int[leftSize];
            System.arraycopy(preorder, 1, newPreLeft, 0, leftSize);
            System.arraycopy(inorder, 0, newInLeft, 0, leftSize);
            root.left = buildTree(newPreLeft, newInLeft);
        }

        if (rightSize > 0) {
            int[] newPreRight = new int[rightSize];
            int[] newInRight = new int[rightSize];
            System.arraycopy(preorder, 1 + leftSize, newPreRight, 0, rightSize);
            System.arraycopy(inorder, leftSize + 1, newInRight, 0, rightSize);
            root.right = buildTree(newPreRight, newInRight);
        }
        return root;
    }
}
