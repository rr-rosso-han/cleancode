package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jiahan on 1/29/15.
 */
public class BinaryTreePostorderTraversal<E> {
    private List<E> result = new ArrayList<>();
    public List<E> postorderTraversal(TreeNode<E> root) {
        if (root == null) {
            return result;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.item);
        return result;
    }

    public List<E> postorderTraversalIteration(TreeNode<E> root) {
        List<E> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();
            if (node != null) {
                list.add(0, node.item);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return list;
    }
}
