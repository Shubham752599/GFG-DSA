class Solution {
  public:
    int maxIndexDifference(string &s) {
        int n = s.size();

        // best[i] stores the farthest reachable index for character ('a' + i)
        vector<int> best(26, -1);

        // Remains -1 if no valid starting index ('a') exists
        int ans = -1;

        // Process from right to left to consider only jumps to the right
        for (int i = n - 1; i >= 0; i--) {
            int farthest = i;

            // Jump to the next alphabet character if it is reachable
            if (s[i] != 'z' && best[s[i] - 'a' + 1] != -1) {
                farthest = best[s[i] - 'a' + 1];
            }

            best[s[i] - 'a'] = max(best[s[i] - 'a'], farthest);

            // Only 'a' can be a starting point
            if (s[i] == 'a') {
                ans = max(ans, farthest - i);
            }
        }

        return ans;
    }
};