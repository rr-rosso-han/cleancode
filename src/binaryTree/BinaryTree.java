package binaryTree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by jiahan on 1/31/15.
 */
public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public LinkedTreeIterator preOrderIterator() {
        return new PreorderIterator();
    }

    private class PreorderIterator implements LinkedTreeIterator {
        private final Stack<TreeNode> stack;

        private PreorderIterator() {
            stack = new Stack<TreeNode>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");
            final TreeNode<E> node = stack.pop();
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            return node.item;
        }
    }

    public LinkedTreeIterator inOrderIterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements LinkedTreeIterator {
        private final Stack<TreeNode> stack;

        private void pushLeftChildren(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        private InorderIterator() {
            stack = new Stack<>();
            pushLeftChildren(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");
            TreeNode<E> res = stack.pop();
            pushLeftChildren(res.right);
            return res.item;
        }
    }

    private class PostOrderIterator implements LinkedTreeIterator {
        private final Stack<TreeNode> stack;

        private PostOrderIterator() {
            this.stack = new Stack<>();
            pushRightChildren(root);
        }
        private void pushRightChildren(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            TreeNode<E> res = stack.pop();
            pushRightChildren(res.left);
            return res.item;
        }
    }
}
