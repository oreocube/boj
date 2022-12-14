import java.io.*;
import java.util.*;

public class P_10026_적록색약 {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        boolean[][] visited1 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (tmp[j] == 'B') {
                    map1[i][j] = map2[i][j] = 0;
                } else {
                    map1[i][j] = tmp[j] == 'R' ? 1 : 2;
                    map2[i][j] = 1;
                }
            }
        }

        int v1 = 0, v2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    bfs(i, j, map1, visited1);
                    v1++;
                }
                if (!visited2[i][j]) {
                    bfs(i, j, map2, visited2);
                    v2++;
                }
            }
        }
        System.out.println(v1 + " " + v2);
    }

    private static void bfs(int startX, int startY, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] != map[x][y]) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
