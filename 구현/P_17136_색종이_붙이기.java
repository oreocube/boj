import java.io.*;
import java.util.*;

public class P_17136_색종이_붙이기 {
    static final int n = 10;
    static int[][] map = new int[n][n];
    static int[] papers = {0, 5, 5, 5, 5, 5};
    static int answer = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, 0);
        System.out.println(answer == 100 ? -1 : answer);
    }

    static void recur(int x, int y, int count) {
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            answer = Math.min(answer, count);
            return;
        }

        if (answer <= count) {
            return;
        }

        if (map[x][y] == 1) {
            for (int i = 1; i <= 5; i++) {
                if (papers[i] > 0 && check(x, y, i)) {
                    papers[i]--;
                    fill(x, y, i, 0);
                    recur(x, y + 1, count + 1);
                    fill(x, y, i, 1);
                    papers[i]++;
                }
            }
        } else {
            recur(x, y + 1, count);
        }
    }

    static boolean check(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (i >= n || j >= n) return false;
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void fill(int x, int y, int len, int value) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                map[i][j] = value;
            }
        }
    }
}
