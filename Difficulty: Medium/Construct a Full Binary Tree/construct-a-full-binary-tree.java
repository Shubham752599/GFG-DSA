/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

import java.util.*;

class Solution {
    int preIndex;
    HashMap<Integer, Integer> map;
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }
        return build(pre, preMirror, 0, preMirror.length - 1);
    }
    private Node build(int[] pre, int[] preMirror, int l, int r) {
        if (preIndex >= pre.length || l > r)
            return null;
        Node root = new Node(pre[preIndex++]);
        if (l == r || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);
        root.left = build(pre, preMirror, idx, r);
        root.right = build(pre, preMirror, l + 1, idx - 1);

        return root;
    }
}