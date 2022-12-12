import java.io.*;
import java.util.*;

public class P_16987_계란으로_계란치기 {
    static int n, answer;
    static int[] s, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        recur(0, 0);
        System.out.println(answer);
    }

    private static void recur(int k, int count) {
        if (k == n) {
            answer = Math.max(answer, count);
            return;
        }

        if (s[k] <= 0 || count == n - 1) {
            recur(k + 1, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (s[i] <= 0 || i == k) continue;
            s[k] -= w[i];
            s[i] -= w[k];
            int c = count;
            if (s[k] <= 0) c++;
            if (s[i] <= 0) c++;
            recur(k + 1, c);
            s[i] += w[k];
            s[k] += w[i];
        }
    }
}
