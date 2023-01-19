import java.io.*;
import java.util.*;

public class P_7795_먹을것인가_먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(N, M, A, B)).append('\n');
        }
        System.out.print(sb);
    }

    private static int solve(int N, int M, int[] A, int[] B) {
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int now = A[i];
            int low = 0, high = M - 1;
            int max = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (now > B[mid]) {
                    max = Math.max(max, mid);
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            sum += max + 1;
        }
        return sum;
    }
}
