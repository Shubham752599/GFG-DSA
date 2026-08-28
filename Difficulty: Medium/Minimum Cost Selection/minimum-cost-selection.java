class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;
        int[] dp = new int[3];

        dp[0] = mat[0][0];
        dp[1] = mat[0][1];
        dp[2] = mat[0][2];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[3];

            curr[0] = mat[i][0] + Math.min(dp[1], dp[2]);

            curr[1] = mat[i][1] + Math.min(dp[0], dp[2]);

            curr[2] = mat[i][2] + Math.min(dp[0], dp[1]);

            dp = curr;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}