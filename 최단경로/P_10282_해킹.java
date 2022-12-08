import java.io.*;
import java.util.*;

public class P_10282_해킹 {
    private static int n;
    private static ArrayList<int[]>[] adj;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adj[b].add(new int[]{a, s});
            }

            bfs(c);
        }
        System.out.print(sb);
    }

    private static void bfs(int start) {
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) dist[i] = INF;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] > dist[now[0]]) continue;
            for (int[] next : adj[now[0]]) {
                int tmp = now[1] + next[1];
                if (dist[next[0]] > tmp) {
                    dist[next[0]] = tmp;
                    queue.add(new int[]{next[0], tmp});
                }
            }
        }

        int count = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) continue;
            count++;
            max = Math.max(max, dist[i]);
        }
        sb.append(count).append(' ').append(max).append('\n');
    }
}
