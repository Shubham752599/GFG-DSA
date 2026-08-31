import java.util.*;

class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        dp[0] = 0;

        for (int x = 1; x <= n; x++) {
            dp[x] = dp[x - 1] + i;

            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + c);
            }
            int y = x - 1;
            long value = dp[y] + 2L * y * d;

            while (!dq.isEmpty()) {
                int last = dq.peekLast();
                long lastValue = dp[last] + 2L * last * d;

                if (lastValue >= value) {
                    dq.pollLast();
                } else {
                    break;
                }
            }

            dq.offerLast(y);
            int minY = (x + 1) / 2;

            while (!dq.isEmpty() && dq.peekFirst() < minY) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                int bestY = dq.peekFirst();

                long cost = dp[bestY]
                        + c
                        + (2L * bestY - x) * d;

                dp[x] = Math.min(dp[x], cost);
            }
        }

        return (int) dp[n];
    }
}