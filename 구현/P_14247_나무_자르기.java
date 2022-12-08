import java.io.*;
import java.util.*;

public class P_14247_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i][0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i][1] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arr[i][0] + (long) arr[i][1] * i;
        }
        System.out.println(answer);
    }
}
