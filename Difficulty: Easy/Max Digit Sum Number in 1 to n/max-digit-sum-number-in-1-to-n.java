class Solution {
    public int findMax(int n) {
        int ans = n;
        int maxSum = digitSum(n);
        int power = 10;

        while (power <= n) {
            int candidate = (n / power) * power - 1;
            if (candidate > 0) {
                int sum = digitSum(candidate);
                if (sum > maxSum || (sum == maxSum && candidate > ans)) {
                    maxSum = sum;
                    ans = candidate;
                }
            }
            power *= 10;
        }
        return ans;
    }
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}