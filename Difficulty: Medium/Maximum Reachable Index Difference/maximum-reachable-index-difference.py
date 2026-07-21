class Solution:
    def maxIndexDifference(self, s):
        best = [-1] * 26
        ans = -1

        for i in range(len(s) - 1, -1, -1):
            ch = ord(s[i]) - ord('a')
            farthest = i

            if ch < 25 and best[ch + 1] != -1:
                farthest = best[ch + 1]

            best[ch] = max(best[ch], farthest)

            if ch == 0:
                ans = max(ans, farthest - i)

        return ans