class Solution {
    public int getCount(Node root, int k) {
        if (root == null) {
            return 0;
        }

        java.util.ArrayList<Integer> costs = new java.util.ArrayList<>();

        java.util.Queue<Node> q = new java.util.LinkedList<>();
        java.util.Queue<Integer> level = new java.util.LinkedList<>();

        q.add(root);
        level.add(1);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int lev = level.poll();

            if (curr.left == null && curr.right == null) {
                costs.add(lev);
            }

            if (curr.left != null) {
                q.add(curr.left);
                level.add(lev + 1);
            }

            if (curr.right != null) {
                q.add(curr.right);
                level.add(lev + 1);
            }
        }

        java.util.Collections.sort(costs);

        int count = 0;

        for (int cost : costs) {
            if (k < cost) {
                break;
            }

            k -= cost;
            count++;
        }

        return count;
    }
}