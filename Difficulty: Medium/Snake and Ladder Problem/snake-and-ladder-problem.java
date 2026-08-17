import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {

        int total = n * n;

        int[] jump = new int[total + 1];

        for (int i = 1; i <= total; i++) {
            jump[i] = i;
        }
        for (int i = 0; i < lad.length; i += 2) {
            int start = lad[i];
            int end = lad[i + 1];
            jump[start] = end;
        }
        for (int i = 0; i < sn.length; i += 2) {
            int start = sn[i];
            int end = sn[i + 1];
            jump[start] = end;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[total + 1];

        queue.offer(1);
        visited[1] = true;

        int throwsCount = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int current = queue.poll();
                for (int dice = 1; dice <= 6; dice++) {

                    int next = current + dice;

                    if (next > total) {
                        continue;
                    }
                    next = jump[next];

                    if (next == total) {
                        return throwsCount + 1;
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            throwsCount++;
        }
        return -1;
    }
}