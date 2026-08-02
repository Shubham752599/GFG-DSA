class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int last = 1; last <= m; last++) {
                int ways = 0;
                for (int prev = 1; prev <= m; prev++) {
                    if (prev % last == 0 || last % prev == 0) {
                        ways += dp[len - 1][prev];
                    }
                }
                dp[len][last] = ways;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[n][i];
        }
        return ans;
    }
}