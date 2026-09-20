class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i+=2){
            ans.add(arr[i]);
        }
        return ans;
    }
}