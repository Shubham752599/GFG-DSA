class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (mat[i][j] == 'X') {
                    right[i][j] = 1;
                    down[i][j] = 1;

                    if (j + 1 < n)
                        right[i][j] += right[i][j + 1];

                    if (i + 1 < n)
                        down[i][j] += down[i + 1][j];
                }
            }
        }
        for (int size = n; size >= 1; size--) {

            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= n; j++) {
                    if (right[i][j] < size)
                        continue;

                    if (down[i][j] < size)
                        continue;

                    if (right[i + size - 1][j] < size)
                        continue;

                    if (down[i][j + size - 1] < size)
                        continue;

                    return size;
                }
            }
        }

        return 0;
    }
}