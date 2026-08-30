import java.util.*;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;

        long[] prefix = new long[n];

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long) r[i] - l[i] + 1;
            prefix[i] = count;
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int k : rank) {
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int i = low;
            long previous = (i == 0) ? 0 : prefix[i - 1];
            long position = k - previous;
            int mark = (int) (l[i] + position - 1);

            ans.add(mark);
        }

        return ans;
    }
}