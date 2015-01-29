package backtrack;

/**
 * Created by jiahan on 1/20/15.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        int l = word.length();
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, word, flag, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board,
                             String word,
                             boolean[][] flag,
                             int i,
                             int j,
                             int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || pos >= word.length() || pos < 0) {
            return false;
        }
        char x = word.charAt(pos);
        if (board[i][j] == x && !flag[i][j]) {
            if (pos == word.length() - 1) {
                return true;
            } else {
                flag[i][j] = true;
                if (existHelper(board, word, flag, i - 1, j, pos + 1)
                        || existHelper(board, word, flag, i, j - 1, pos + 1)
                        || existHelper(board, word, flag, i + 1, j, pos + 1)
                        || existHelper(board, word, flag, i, j + 1, pos + 1)) {
                    return true;
                }
                flag[i][j] = false;
                return false;
            }
        } else {
            return false;
        }
    }
}
