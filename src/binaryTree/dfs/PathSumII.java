package binaryTree.dfs;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 2/4/15.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        int[] pathSum = new int[1];
        pathSum[0] = root.val;
        path.add(root.val);
        pathSumHelper(result, path, root, sum, pathSum);
        return result;
    }

    private void pathSumHelper(List<List<Integer>> result,
                               List<Integer> path,
                               TreeNode x,
                               int sum,
                               int[] pathSum) {

        if (x.left == null && x.right == null) {
            if (pathSum[0] == sum) {
                result.add(new ArrayList<Integer>(path));
                return;
            } else {
                return;
            }
        }

        if (x.left != null) {
            path.add(x.left.val);
            pathSum[0] += x.left.val;
            pathSumHelper(result, path, x.left, sum, pathSum);
            pathSum[0] -= x.left.val;
            path.remove(path.size() - 1);
        }
        if (x.right != null) {
            path.add(x.right.val);
            pathSum[0] += x.right.val;
            pathSumHelper(result, path, x.right, sum, pathSum);
            pathSum[0] -= x.right.val;
            path.remove(path.size() - 1);
        }
        return;
    }
}
