package bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiahan on 2/22/15.
 */
public class SurroundedRegions {

    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void test() {
        char[][] a = {{'O','O','O'}, {'O','O','O'}, {'O','O','O'}};
        char[][] c = {{'O','O'}, {'O','O'}};
        solve(c);
        //solve(a);
        return;
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] marked = new boolean[rows][cols];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Node(i, 0));
                marked[i][0] = true;
            }
            if (board[i][cols - 1] == 'O') {
                queue.offer(new Node(i, cols - 1));
                marked[i][cols - 1] = true;
            }
        }

        for (int i = 1; i < cols - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Node(0, i));
                marked[0][i] = true;
            }
            if (board[rows - 1][i] == 'O') {
                queue.offer(new Node(rows - 1, i));
                marked[rows - 1][i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                board[x][y] = 'Y';
                if (x > 0 && board[x - 1][y] == 'O' && !marked[x - 1][y]) {
                    queue.offer(new Node(x - 1, y));
                    marked[x - 1][y] = true;
                }
                if (x < rows - 1 && board[x + 1][y] == 'O' && !marked[x + 1][y]) {
                    queue.offer(new Node(x + 1, y));
                    marked[x + 1][y] = true;
                }
                if (y > 0 && board[x][y - 1] == 'O' && !marked[x][y - 1]) {
                    queue.offer(new Node(x, y - 1));
                    marked[x][y - 1] = true;
                }
                if (y < cols - 1 && board[x][y + 1] == 'O' && !marked[x][y + 1]) {
                    queue.offer(new Node(x, y + 1));
                    marked[x][y + 1] = true;
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !marked[i][j]) {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
