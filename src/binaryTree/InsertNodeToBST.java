package binaryTree;

/**
 * Created by jiahan on 1/30/15.
 */
public class InsertNodeToBST {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        }
        if (key > root.val) {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
