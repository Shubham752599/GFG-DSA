import java.util.*;

class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : arr) {
            int left = map.getOrDefault(x - 1, 0);
            int right = map.getOrDefault(x + 1, 0);

            int current = Math.max(left, right) + 1;

            map.put(x, Math.max(map.getOrDefault(x, 0), current));

            ans = Math.max(ans, map.get(x));
        }
        return ans;
    }
}