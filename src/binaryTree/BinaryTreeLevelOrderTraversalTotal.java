package binaryTree;

import org.junit.Test;

import java.util.*;

/**
 * Created by jiahan on 1/30/15.
 */
public class BinaryTreeLevelOrderTraversalTotal {

    @Test
    public void levelOrder() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        List<List<Integer>> r = levelOrder(a);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            path.add(x.val);
            if (x.left != null) {
                queue2.offer(x.left);
            }
            if (x.right != null) {
                queue2.offer(x.right);
            }
            if (queue.isEmpty()) {
                result.add(new ArrayList<Integer>(path));
                path.clear();
                queue = new LinkedList<>(queue2);
                queue2.clear();
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrderOneQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                level.add(x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
