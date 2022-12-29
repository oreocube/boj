import java.io.*;
import java.util.*;

public class P_14002_가장_긴_증가하는_부분_수열_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int[] indexOrder = new int[n + 1];
        int len = 1;
        dp[1] = arr[1];
        indexOrder[1] = 1;

        for (int i = 2; i <= n; i++) {
            int index = lowerBound(dp, 1, len, arr[i]);
            indexOrder[i] = index;
            if (index > len) {
                dp[++len] = arr[i];
            } else {
                dp[index] = arr[i];
            }
        }

        int answer = len;
        int[] result = new int[n + 1];
        for (int i = n; i > 0; i--) {
            if (indexOrder[i] != len) continue;
            result[len--] = arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= answer; i++) {
            sb.append(result[i]).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(answer);
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
