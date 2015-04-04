package binaryTree.dfs;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 2/2/15.
 */
public class SumRoottoLeafNumbers {


    public int sumNumbers(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        sumNumbersHelper(result, path, root.left, root.right);
        int total = 0;
        for (List<Integer> list : result) {
            int sum = 0, j = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                sum += list.get(i) * j;
                j = j * 10;
            }
            total += sum;
        }
        return total;
    }

    private void sumNumbersHelper(List<List<Integer>> result,
                                  List<Integer> path,
                                  TreeNode left,
                                  TreeNode right) {

        if (left == null && right == null) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (left != null) {
            path.add(left.val);
            sumNumbersHelper(result, path, left.left, left.right);
            path.remove(path.size() - 1);
        }
        if (right != null) {
            path.add(right.val);
            sumNumbersHelper(result, path, right.left, right.right);
            path.remove(path.size() - 1);
        }
        return;
    }

    public int sumNumbersII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> sumSet = new ArrayList<>();
        Integer currentSum = 0;
        sumNumbersIIHelper(root.left, root.right, root.val, currentSum);
        return currentSum;
    }

    private void sumNumbersIIHelper(TreeNode left,
                                  TreeNode right,
                                  int pathSum,
                                  Integer currentSum) {

        if (left == null && right == null) {
            currentSum += pathSum;
            return;
        }

        if (left != null) {
            pathSum = pathSum * 10 + left.val;
            sumNumbersIIHelper(left.left, left.right, pathSum, currentSum);
            pathSum = (pathSum - left.val) / 10;
        }
        if (right != null) {
            pathSum = pathSum * 10 + right.val;
            sumNumbersIIHelper(right.left, right.right, pathSum, currentSum);
            pathSum = (pathSum - right.val) / 10;
        }
        return;
    }

}
