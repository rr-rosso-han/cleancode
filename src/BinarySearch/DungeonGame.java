package BinarySearch;

/**
 * Created by jiahan on 2/8/15.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(0 - dungeon[m - 1][n - 1], 0);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 0);
        }

        for (int i = n - 2; i >= 0; i--) {
            health[m - 1][i] = Math.max(health[m - 1][i + 1] - dungeon[m - 1][i], 0);
        }


        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                health[i][j] = Math.max(Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j], 0);
            }
        }

        return health[0][0] + 1;
    }
}
