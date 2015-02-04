package binaryTree.dfs;

import org.junit.Test;

/**
 * Created by jiahan on 2/3/15.
 */
public class PopulatingNextRightPointersinEachNodeII {

    @Test
    public void connect() {
        TreeLinkNode r = new TreeLinkNode(1);
        TreeLinkNode a = new TreeLinkNode(2);
        TreeLinkNode b = new TreeLinkNode(3);
        TreeLinkNode c = new TreeLinkNode(4);
        TreeLinkNode d = new TreeLinkNode(5);
        r.left = a;
        r.right = b;

        a.left = c;
        a.right = d;

        connect(r);
        return;
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        boolean isLeft = false;
        TreeLinkNode parent = null;
        connect(root, parent);
        return;
    }

    private void connect(TreeLinkNode node,
                         TreeLinkNode parent) {
        if (node == null) {
            return;
        }
        if (parent != null) {
            if (parent.right != node) {
                node.next = parent.right;
            } else {
                addNext(node, parent);
            }
        } else {
            node.next = null;
        }

        parent = node;
        if (node.right != null) {
            connect(node.right, parent);
        }
        if (node.left != null) {
            connect(node.left, parent);
        }
        return;
    }

    private void addNext(TreeLinkNode node, TreeLinkNode parent) {
        TreeLinkNode tmp = parent.next;
        while (tmp != null && tmp.left == null && tmp.right == null) {
            tmp = tmp.next;
        }
        if (tmp != null) {
            node.next = tmp.left != null ? tmp.left : tmp.right;
        } else {
            node.next = null;
        }
    }
}
