import java.io.*;
import java.util.*;

public class P_3109_빵집 {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (dfs(i, 0)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) {
        int ny = y + 1;
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            if (nx < 0 || nx >= n) continue;
            if (map[nx][ny] == 'x') continue;
            if (visited[nx][ny]) continue;

            if (ny == m - 1) return true;
            visited[nx][ny] = true;
            if (dfs(nx, ny)) return true;
        }
        return false;
    }
}
