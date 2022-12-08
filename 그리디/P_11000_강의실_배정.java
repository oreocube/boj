import java.io.*;
import java.util.*;

public class P_11000_강의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, t};
        }

        // 시작시간 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // 먼저 끝나는 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 시작시간이 가장 빨리 끝나는 강의실보다 앞이면 다른 강의실 배정
            if (pq.isEmpty() || arr[i][0] < pq.peek()[1]) {
                pq.add(arr[i]);
                count++;
            } else {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(count);
    }
}
