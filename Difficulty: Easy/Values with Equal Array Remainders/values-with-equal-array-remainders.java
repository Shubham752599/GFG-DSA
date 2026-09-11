class Solution {
    public int sameMod(int[] arr) {
        boolean same = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0]) {
                same = false;
                break;
            }
        }
        if (same) {
            return -1;
        }
        int gcd = 0;

        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            gcd = findGcd(gcd, diff);
        }
        int count = 0;
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                count++;
                if (i != gcd / i) {
                    count++;
                }
            }
        }
        return count;
    }
    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}