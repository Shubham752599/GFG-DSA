class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int longest = 1;
        int current = 1;
        for (int x = 2; x <= n; x++) {
            if (pos[x - 1] < pos[x]) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return n - longest;
    }
}