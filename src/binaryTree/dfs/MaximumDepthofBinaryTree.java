package binaryTree.dfs;

import binaryTree.TreeNode;
import com.sun.swing.internal.plaf.metal.resources.metal;

/**
 * Created by jiahan on 12/25/14.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
