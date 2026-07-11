class Solution {
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;
        boolean[][] vis = new boolean[n][m];
        return dfs(mat, xs, ys, xd, yd, vis);
    }
    private int dfs(int[][] mat, int x, int y, int xd, int yd, boolean[][] vis) {

        if (x == xd && y == yd)
            return 0;
        vis[x][y] = true;

        int ans = -1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dr[k];
            int ny = y + dc[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                mat[nx][ny] == 1 && !vis[nx][ny]) {

                int res = dfs(mat, nx, ny, xd, yd, vis);
                if (res != -1)
                    ans = Math.max(ans, res + 1);
            }
        }
        vis[x][y] = false;

        return ans;
    }
}