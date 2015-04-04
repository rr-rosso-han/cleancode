package binaryTree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by jiahan on 1/31/15.
 */
public class BinaryTree<E> {
    private TreeNode<E> root;
    public BinaryTree() {
    }

    //public BinaryTree(TreeNode<E> root) {
    //    this.root = root;
    //}
    @Test
    public void preOrderIteratorTest() {
        TreeNode a1 = new TreeNode(Integer.valueOf(1));
        TreeNode a2 = new TreeNode(Integer.valueOf(2));
        TreeNode a3 = new TreeNode(Integer.valueOf(3));
        TreeNode a4 = new TreeNode(Integer.valueOf(4));
        TreeNode a5 = new TreeNode(Integer.valueOf(5));

        a1.left = a2;
        a2.right = a3;
        a1.right = a4;
        a4.left = a5;
        this.root = a1;
        Iterator<E> it = preOrderIterator();
        System.out.println("======Preorder=======");
        while(it.hasNext()) {
            E item = it.next();
            System.out.println(item);
        }
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

    @Test
    public void inOrderIteratorTest() {
        TreeNode a1 = new TreeNode(Integer.valueOf(1));
        TreeNode a2 = new TreeNode(Integer.valueOf(2));
        TreeNode a3 = new TreeNode(Integer.valueOf(3));
        TreeNode a4 = new TreeNode(Integer.valueOf(4));
        TreeNode a5 = new TreeNode(Integer.valueOf(5));

        a1.left = a2;
        a2.right = a3;
        a1.right = a4;
        a4.left = a5;
        this.root = a1;
        Iterator<E> it = inOrderIterator();
        System.out.println("======Inorder=======");
        while(it.hasNext()) {
            E item = it.next();
            System.out.println(item);
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

    @Test
    public void postOrderIteratorTest() {
        TreeNode a1 = new TreeNode(Integer.valueOf(1));
        TreeNode a2 = new TreeNode(Integer.valueOf(2));
        TreeNode a3 = new TreeNode(Integer.valueOf(3));
        TreeNode a4 = new TreeNode(Integer.valueOf(4));
        TreeNode a5 = new TreeNode(Integer.valueOf(5));

        a1.left = a2;
        a2.right = a3;
        a1.right = a4;
        a4.left = a5;
        this.root = a1;
        System.out.println("======Postorder=======");
        Iterator<E> it = postOrderIterator();
        while(it.hasNext()) {
            E item = it.next();
            System.out.println(item);
        }
    }
    public LinkedTreeIterator postOrderIterator() {
        return new PostOrderIterator();
    }
    private class PostOrderIterator implements LinkedTreeIterator {
        private final Stack<TreeNode> stack;

        private void initStack(TreeNode node) {
            if (node == null) return;
            stack.push(node);
            initStack(node.right);
            initStack(node.left);
        }
        private PostOrderIterator() {
            this.stack = new Stack<>();
            initStack(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes remain to iterate");
            }
            TreeNode<E> res = stack.pop();
            return res.item;
        }
    }
}
