class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        long total = 1L *n * (n + 1)/2;
        long sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (int) (total - sum);
    }
}