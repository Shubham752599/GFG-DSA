class Solution {
    public int maxDiffSum(int[] arr) {
        int prevOriginal = 0;
        int prevOne = 0;
        for(int i=1;i<arr.length;i++){
            int prev = arr[i-1];
            int curr= arr[i];
            int currentOriginal = Math.max(
                prevOriginal + Math.abs(curr - prev),
                prevOne + Math.abs(curr - 1)
                );
                
            int currentOne = Math.max(
                prevOriginal + Math.abs(1-prev),
                prevOne
                );
                
            prevOriginal=currentOriginal;
            prevOne=currentOne;
        }
        return Math.max(prevOriginal, prevOne);
    }
}