class Solution {
    static final int mod = 1000000007;
  
    public int maxAmount(int[] arr, int k) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int tickets:arr){
            pq.offer(tickets);
            
        }
        long ans = 0;
        while(k > 0 && !pq.isEmpty()){
            int maxTicket = pq.poll();
            ans= (ans + maxTicket)% mod;
            maxTicket--;
            if(maxTicket>0){
                pq.offer(maxTicket);
                
            }
            k--;
        }
        return (int)ans;
        }
};