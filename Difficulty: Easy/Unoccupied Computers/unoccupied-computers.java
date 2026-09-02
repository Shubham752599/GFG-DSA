class Solution {
    public int solve(int n, String s) {
        boolean[] gotComputer = new boolean[26];
        boolean[] rejected = new boolean[26];
        int occupied = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';
            if (!gotComputer[idx] && !rejected[idx]) {

                if (occupied < n) {
                    gotComputer[idx] = true;
                    occupied++;
                } else {
                    rejected[idx] = true;
                    ans++;
                }
            } else {
                if (gotComputer[idx]) {
                    gotComputer[idx] = false;
                    occupied--;
                }
            }
        }
        return ans;
    }
}