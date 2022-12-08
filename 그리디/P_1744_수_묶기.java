import java.io.*;
import java.util.*;

public class P_1744_수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] > 0 || arr[left + 1] > 0) break;
            sum += arr[left] * arr[left + 1];
            left += 2;
        }

        while (right > left) {
            if (arr[right] <= 1 || arr[right - 1] <= 1) break;
            sum += arr[right] * arr[right - 1];
            right -= 2;
        }

        while (left <= right) sum += arr[left++];

        System.out.println(sum);
    }
}
