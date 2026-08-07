class Solution {
    public int countFriendsPairings(int n) {
        // code here
        return solve(n);
    }
    private int solve(int n){
        if(n <= 2){
            return n;
        }
        int single=solve(n-1);
        int pair=(n-1)*solve(n-2);
        return(single+pair);
    }
}
