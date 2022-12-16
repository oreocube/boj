import java.io.*;
import java.util.*;

public class P_5014_스타트링크 {
    static int n;
    static int[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        dir = new int[2];
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        int answer = bfs(src, dest);
        if (answer == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer - 1);
        }
    }

    private static int bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] dist = new int[n + 1];
        dist[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int d : dir) {
                int next = now + d;
                if (next <= 0 || next > n) continue;
                if (dist[next] != 0) continue;
                dist[next] = dist[now] + 1;
                if (next == dest) return dist[next];
                queue.add(next);
            }
        }
        return dist[dest];
    }
}
