/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) {
                return false;
            }

            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();

            for (int i = 0; i < size1; i++) {
                Node curr = q1.poll();

                map1.put(curr.data, map1.getOrDefault(curr.data, 0) + 1);

                if (curr.left != null) {
                    q1.add(curr.left);
                }

                if (curr.right != null) {
                    q1.add(curr.right);
                }
            }

            for (int i = 0; i < size2; i++) {
                Node curr = q2.poll();

                map2.put(curr.data, map2.getOrDefault(curr.data, 0) + 1);

                if (curr.left != null) {
                    q2.add(curr.left);
                }

                if (curr.right != null) {
                    q2.add(curr.right);
                }
            }

            if (!map1.equals(map2)) {
                return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}

