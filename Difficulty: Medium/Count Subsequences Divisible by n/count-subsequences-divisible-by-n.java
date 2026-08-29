class Solution {
    public int countSubsequences(String s, int n) {
        final long MOD = 1000000007L;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            long[] next = dp.clone();
            next[digit % n] = (next[digit % n] + 1) % MOD;
            for (int r = 0; r < n; r++) {
                if (dp[r] == 0) {
                    continue;
                }

                int newRemainder = (r * 10 + digit) % n;

                next[newRemainder] =
                    (next[newRemainder] + dp[r]) % MOD;
            }

            dp = next;
        }

        return (int) dp[0];
    }
}