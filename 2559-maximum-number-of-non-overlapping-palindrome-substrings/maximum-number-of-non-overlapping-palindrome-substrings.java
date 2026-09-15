class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }
        int[] dp = new int[n + 1];
        for (int end = 1; end <= n; end++) {
            dp[end] = dp[end - 1];
            for (int start = 0; start <= end - k; start++) {
                if (isPal[start][end - 1]) {
                    dp[end] = Math.max(
                        dp[end],
                        dp[start] + 1
                    );
                }
            }
        }
        return dp[n];
    }
}