import java.io.*;
import java.util.*;

public class P_18352_특정_거리의_도시_찾기 {
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }

        dijkstra(x, k);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i).append('\n');
                count++;
            }
        }

        System.out.print(count == 0 ? -1 : sb);
    }

    private static void dijkstra(int start, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[1] > dist[now[0]]) continue;
            if (now[1] > k) continue;
            for (int next : adj[now[0]]) {
                int tmp = now[1] + 1;
                if (dist[next] > tmp) {
                    dist[next] = tmp;
                    pq.add(new int[]{next, tmp});
                }
            }
        }
    }
}
