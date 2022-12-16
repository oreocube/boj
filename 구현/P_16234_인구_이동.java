import java.io.*;
import java.util.*;

public class P_16234_인구_이동 {
    static int n, l, r;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    flag = flag | bfs(i, j, visited);
                }
            }
            if (!flag) break;
            count++;
        }
        System.out.println(count);
    }

    private static boolean bfs(int startX, int startY, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        ArrayList<int[]> pos = new ArrayList<>();
        pos.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int sum = arr[startX][startY];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                if (diff >= l && diff <= r) {
                    visited[nx][ny] = true;
                    int[] next = new int[]{nx, ny};
                    queue.add(next);
                    pos.add(next);
                    sum += arr[nx][ny];
                }
            }
        }

        if (pos.size() < 2) return false;

        int target = sum / pos.size();
        for (int[] p : pos) {
            arr[p[0]][p[1]] = target;
        }
        return true;
    }
}
