import java.io.*;
import java.util.*;

public class P_21918_전구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                arr[b] = c;
            } else if (a == 2) {
                for (int j = b; j < c; j++) arr[j] ^= 1;
            } else if (a == 3) {
                for (int j = b; j < c; j++) arr[j] &= 0;
            } else if (a == 4) {
                for (int j = b; j < c; j++) arr[j] |= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
