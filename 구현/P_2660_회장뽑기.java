import java.io.*;
import java.util.*;

public class P_2660_회장뽑기 {
    private static final int INF = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minScore = INF;
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                score = Math.max(score, dist[i][j]);
            }
            if (minScore > score) {
                minScore = score;
                candidates.clear();
                candidates.add(i);
            } else if (minScore == score) {
                candidates.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(' ');
        sb.append(candidates.size()).append('\n');
        for (int i : candidates) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
