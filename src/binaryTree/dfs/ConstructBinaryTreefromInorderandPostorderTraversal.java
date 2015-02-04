package binaryTree.dfs;

import binaryTree.TreeNode;

/**
 * Created by jiahan on 2/4/15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        if( postorder.length != inorder.length) {
            return null;
        }
        if(postorder.length == 0) {
            return null;
        }
        if(postorder.length == 1) {
            if(postorder[0] != inorder[0]) {
                return null;
            }
            return new TreeNode(postorder[0]);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int root_val = postorder[postEnd];
        TreeNode root = new TreeNode(root_val);
        int root_index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root_val) {
                root_index = i;
                break;
            }
        }
        if (root_index == -1) return null;
        int len = root_index - inStart;
        root.left = buildTree(postorder, postStart, postStart + len - 1, inorder, inStart, root_index - 1);
        root.right = buildTree(postorder, postStart + len, postEnd - 1,inorder, root_index + 1,inEnd);
        return root;
    }
}
