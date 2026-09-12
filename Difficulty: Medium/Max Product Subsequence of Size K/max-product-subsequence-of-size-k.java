class Solution {
    public int maxProduct(int[] arr, int k) {

        int n = arr.length;
        long[][] max = new long[k + 1][n + 1];
        long[][] min = new long[k + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            max[0][j] = 1;
            min[0][j] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                max[i][j] = Long.MIN_VALUE;
                min[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                max[i][j] = max[i][j - 1];
                min[i][j] = min[i][j - 1];
                if (j >= i) {
                    long x = arr[j - 1];

                    max[i][j] = Math.max(max[i][j],
                            Math.max(max[i - 1][j - 1] * x,
                                     min[i - 1][j - 1] * x));
                    min[i][j] = Math.min(min[i][j],
                            Math.min(max[i - 1][j - 1] * x,
                                     min[i - 1][j - 1] * x));
                }
            }
        }
        return (int) max[k][n];
    }
}