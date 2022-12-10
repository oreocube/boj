import java.io.*;
import java.util.*;

public class P_1477_휴게소_세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = 0;
        arr[n + 1] = l;
        Arrays.sort(arr);

        int left = 1, right = l - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                int dist = arr[i] - arr[i - 1];
                count += dist / mid;
                if (dist % mid == 0) count--;
            }

            if (count > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
