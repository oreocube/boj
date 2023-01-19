import java.io.*;
import java.util.*;

public class P_2512_예산 {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if (sum <= M) {
            System.out.println(arr[N - 1]);
            return;
        }

        long answer = 0;
        long low = 0, high = M;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (isValid(mid)) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isValid(long limit) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= limit) {
                sum += arr[i];
            } else {
                sum += (N - i) * limit;
                break;
            }
        }
        return sum <= M;
    }
}
