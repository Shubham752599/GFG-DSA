import java.util.*;

class Solution {

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int[] first = bfs(adj, 1);
        int farthestNode = first[0];
        int[] second = bfs(adj, farthestNode);
        int diameter = second[1];
        return (diameter + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        
        int n = adj.size();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj.get(node - 1)) {

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[node] + 1;

                    q.add(next);

                    if (dist[next] > maxDist) {
                        maxDist = dist[next];
                        farthestNode = next;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}