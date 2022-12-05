import java.io.*;
import java.util.*;

public class P_1504_특정한_최단_경로 {
    static ArrayList<int[]>[] adj;
    static int INF = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) adj[i + 1] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N
        int[] distFromOne = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        int case1, case2;
        if (distFromOne[v1] == INF || distFromV1[v2] == INF || distFromV2[n] == INF) {
            case1 = INF;
        } else {
            case1 = distFromOne[v1] + distFromV1[v2] + distFromV2[n];
        }

        if (distFromOne[v2] == INF || distFromV2[v1] == INF || distFromV1[n] == INF) {
            case2 = INF;
        } else {
            case2 = distFromOne[v2] + distFromV2[v1] + distFromV1[n];
        }

        if (case1 == INF && case2 == INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[1] > dist[now[0]]) continue;
            for (int[] next : adj[now[0]]) {
                int tmp = now[1] + next[1];
                if (dist[next[0]] > tmp) {
                    dist[next[0]] = tmp;
                    pq.add(new int[]{next[0], tmp});
                }
            }
        }
        return dist;
    }
}
