class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1) {
            return false;
        }
        Boolean[][][] dp = new Boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0, dp);
    }

    private boolean dfs(char[][] grid, int i, int j, int balance, Boolean[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (balance < 0) {
            return false;
        }

        if (balance > m + n - 1 - i - j) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }
        boolean result = false;

        if (i + 1 < m) {
            result = dfs(grid, i + 1, j, balance, dp);
        }

        if (!result && j + 1 < n) {
            result = dfs(grid, i, j + 1, balance, dp);
        }

        dp[i][j][balance] = result;
        return result;
    }
}