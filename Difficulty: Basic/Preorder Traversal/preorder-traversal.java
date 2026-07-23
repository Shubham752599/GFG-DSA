/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }

    void solve(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        solve(root.left, ans);
        solve(root.right, ans);
    }
}