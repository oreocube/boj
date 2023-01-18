import java.io.*;
import java.util.*;;

public class P_1015_수열_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i][0] = i;
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, Comparator.comparingInt(o -> o[1]));

        int[] P = new int[N];
        for (int i = 0; i < N; i++) P[A[i][0]] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(P[i]).append(' ');
        System.out.println(sb);
    }
}
