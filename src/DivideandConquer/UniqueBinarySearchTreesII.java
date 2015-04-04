package DivideandConquer;

import binaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 2/14/15.
 */
public class UniqueBinarySearchTreesII {
    @Test
    public void test() {
        int n = 3;
        List<TreeNode> r = generateTrees(n);
        return;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> result = new ArrayList<>();
        if (l > r) {
            result.add(null);
            return result;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);
            for (TreeNode lf : left) {
                for (TreeNode rt: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lf;
                    root.right = rt;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
