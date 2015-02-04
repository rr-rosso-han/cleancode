package binaryTree.dfs;

import binaryTree.TreeNode;
import org.junit.Test;

/**
 * Created by jiahan on 2/3/15.
 */
public class PopulatingNextRightPointersinEachNode {

    @Test
    public void connect() {
        TreeLinkNode r = new TreeLinkNode(0);
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        r.left = a;
        r.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        connect(r);
        return;
    }
    //private TreeLinkNode parent;
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        boolean isLeft = false;
        TreeLinkNode parent = null;
        connect(root, parent, isLeft);
        return;
    }

    private void connect(TreeLinkNode node,
                         TreeLinkNode parent,
                         boolean isLeft) {
        if (node == null) {
            return;
        }
        if (parent == null) {
            node.next = null;
        } else {
            if (isLeft) {
                node.next = parent.right;
            } else {
                if (parent.next != null) {
                    node.next = parent.next.left;
                } else {
                    node.next = null;
                }
            }
        }
        parent = node;
        if (node.left != null) {
            connect(node.left, parent, true);
        }
        if (node.right != null) {
            connect(node.right, parent, false);
        }
        return;
    }
}