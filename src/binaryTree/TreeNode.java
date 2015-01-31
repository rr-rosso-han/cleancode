package binaryTree;

/**
 * Created by jiahan on 12/25/14.
 */
public class TreeNode<E> {
    public E item;
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(E x) { item = x; }
    public TreeNode(int x) { val = x; }
}
