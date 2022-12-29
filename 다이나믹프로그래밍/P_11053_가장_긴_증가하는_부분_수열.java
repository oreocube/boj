import java.io.*;
import java.util.*;

public class P_11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[len] < arr[i]) {
                dp[++len] = arr[i];
            } else {
                int index = lowerBound(dp, 1, len, arr[i]);
                if (dp[index] > arr[i]) {
                    dp[index] = arr[i];
                }
            }
        }
        System.out.println(len);
    }

    private static int lowerBound(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
