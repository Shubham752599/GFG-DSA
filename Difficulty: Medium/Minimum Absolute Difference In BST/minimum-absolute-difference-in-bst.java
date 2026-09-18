/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    Integer prev = null;
    int minDiff = Integer.MAX_VALUE;
    
    public int absDiff(Node root) {
        // code here
        if(root == null) return minDiff;
        absDiff(root.left);
        if(prev != null) minDiff = Math.min(minDiff, root.data - prev);
        prev=root.data;
        absDiff(root.right);
        return minDiff;
        
    }
}
