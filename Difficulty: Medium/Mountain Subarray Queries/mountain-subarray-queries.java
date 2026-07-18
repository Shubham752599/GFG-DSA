import java.util.*;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] inc = new int[n];
        inc[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) inc[i] = inc[i - 1];
            else inc[i] = i;
        }

        int[] dec = new int[n];
        dec[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) dec[i] = dec[i + 1];
            else dec[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            int lo = l, hi = r, peakStart = l;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (inc[mid] <= l) {
                    peakStart = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            ans.add(dec[peakStart] >= r);
        }

        return ans;
    }
}