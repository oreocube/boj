import java.io.*;
import java.util.*;

public class P_2170_선_긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int answer = arr[0][1] - arr[0][0];
        int last = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] <= last) {
                answer += Math.max(0, arr[i][1] - last);
                last = Math.max(last, arr[i][1]);
            } else {
                answer += arr[i][1] - arr[i][0];
                last = arr[i][1];
            }
        }
        System.out.println(answer);
    }
}
