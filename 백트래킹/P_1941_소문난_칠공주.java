import java.io.*;
import java.util.*;

public class P_1941_소문난_칠공주 {
    static final int n = 5;
    static char[][] map = new char[n][n];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        recur(0, 0, 0, new boolean[n][n]);
        System.out.println(answer);
    }

    private static void recur(int k, int p, int s, boolean[][] check) {
        if (k == 7) {
            if (s >= 4) {
                if (bfs(check)) answer++;
            }
            return;
        }

        if (p == 25) return;

        int x = p / n;
        int y = p % n;

        recur(k, p + 1, s, check);
        if (map[x][y] == 'S') s++;
        check[x][y] = true;
        recur(k + 1, p + 1, s, check);
        check[x][y] = false;
    }

    private static boolean bfs(boolean[][] check) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) continue;
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                break;
            }
            if (!queue.isEmpty()) break;
        }

        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!check[nx][ny]) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                count++;
                queue.add(new int[]{nx, ny});
            }
        }
        return count == 7;
    }
}
