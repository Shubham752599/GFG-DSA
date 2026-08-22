/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    boolean findPath(Node root, int target, StringBuilder path) {

        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }

    int countTurns(String path) {

        int turns = 0;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1)) {
                turns++;
            }
        }

        return turns;
    }

    public int numberOfTurns(Node root, int p, int q) {

        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();
        if (!findPath(root, p, pathP) ||
            !findPath(root, q, pathQ)) {
            return -1;
        }
        int i = 0;

        while (i < pathP.length() &&
               i < pathQ.length() &&
               pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }
        if (i == pathP.length() && i == pathQ.length()) {
            return -1;
        }

        int turns = 0;
        for (int j = pathP.length() - 1; j > i; j--) {
            if (pathP.charAt(j) != pathP.charAt(j - 1)) {
                turns++;
            }
        }
        if (i < pathP.length() && i < pathQ.length()) {
            if (pathP.charAt(i) != pathQ.charAt(i)) {
                turns++;
            }
        }

        for (int j = i + 1; j < pathQ.length(); j++) {
            if (pathQ.charAt(j) != pathQ.charAt(j - 1)) {
                turns++;
            }
        }
        return turns == 0 ? -1 : turns;
    }
}