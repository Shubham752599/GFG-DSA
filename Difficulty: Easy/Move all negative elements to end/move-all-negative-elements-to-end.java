class Solution {
    public void segregateElements(int[] arr) {
        // code here
        int j=0;
        int n = arr.length;
        int[] temp = new int[n];
        
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                temp[j++]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                temp[j++]=arr[i];
            }
        }
        for (int i=0;i<n;i++){
            arr[i] = temp[i];
        }
    }        
}    