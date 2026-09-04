class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if(m>=n){
            int total=0;
            for(int x:arr){
                total+=x;
            }
            return total;
        }
        int sum=0;
        for(int i=0;i<m;i++){
            sum+=arr.get(i);
            
        }
        int ans=sum;
        for(int window=1;window<n;window++){
            int sub = window-1;
            sum-=arr.get(sub);
            int odd=(window+m-1)%n;
            sum+=arr.get(odd);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}