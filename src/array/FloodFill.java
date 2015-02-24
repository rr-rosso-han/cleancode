package array;

/**
 * Created by jiahan on 2/22/15.
 */
public class FloodFill {
    public void floodFillUtil(int[][] screen, int x, int y, int prevC, int newC) {
        int row = screen.length;
        int col = screen[0].length;
        // Base cases
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }

        if (screen[x][y] != prevC) {
            return;
        }

        // Replace the color at (x, y)
        screen[x][y] = newC;

        // Recur for north, east, south and west
        floodFillUtil(screen, x + 1, y, prevC, newC);
        floodFillUtil(screen, x - 1, y, prevC, newC);
        floodFillUtil(screen, x, y + 1, prevC, newC);
        floodFillUtil(screen, x, y - 1, prevC, newC);
    }
}
