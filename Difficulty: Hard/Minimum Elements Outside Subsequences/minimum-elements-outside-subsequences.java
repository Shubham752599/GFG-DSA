
class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {

                if (dp[i][j] == -1) {
                    continue;
                }

                int inc = i - 1;
                int dec = j - 1;

                int last = Math.max(inc, dec);
                for (int k = last + 1; k < n; k++) {

                    if (inc == -1 || arr[k] > arr[inc]) {
                        dp[k + 1][j] =
                            Math.max(dp[k + 1][j], dp[i][j] + 1);
                    }
                    if (dec == -1 || arr[k] < arr[dec]) {
                        dp[i][k + 1] =
                            Math.max(dp[i][k + 1], dp[i][j] + 1);
                    }
                }
            }
        }
        int maxSelected = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                maxSelected = Math.max(maxSelected, dp[i][j]);
            }
        }
        return n - maxSelected;
    }
}
