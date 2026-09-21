class Solution {
    public int maxStep(int[] arr) {
        // code here
        int maxi=0;
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                count++;
                maxi= Math.max(maxi, count);
            }
            else count=0;
        }
        return maxi;
    }
}