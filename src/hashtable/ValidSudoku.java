package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiahan on 3/3/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9
                || board[0].length != 9) {
            return false;
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (!isValidChar(board[i][j], set)) {
                    return false;
                }
                if (!isValidChar(board[j][i], set)) {
                    return false;
                }

            }
        }
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (!isValidChar(board[j][i], set)) {
                    return false;
                }
            }
        }

        // check the blocks.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // clear the set at every block.
                set.clear();
                for (int k = 0; k < 9; k++) {
                    if (!isValidChar(board[i*3 + k / 3][j*3 + k % 3], set)) { // here is a bug
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidChar(char c, Set<Character> set) {
        if (c == '.') {
            return true;
        }

        if (c < '1' || c > '9') {
            return false;
        }
        if (set.contains(c)) {
            return false;
        }
        set.add(c);
        return true;
    }
}
