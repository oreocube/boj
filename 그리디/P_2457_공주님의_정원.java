import java.io.*;
import java.util.*;

public class P_2457_공주님의_정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));

        int date = 301;
        if (arr[0][0] > date) {
            System.out.println(0);
            return;
        }

        int i = 0;
        int answer = 0;
        while (date <= 1130) {
            int max = 0;
            // 꽃이 지기 전에 피는 꽃 중에 가장 오래 피는 꽃 찾기
            for (; i < n; i++) {
                if (arr[i][0] > date) break;
                if (date < arr[i][1]) {
                    max = Math.max(max, arr[i][1]);
                }
            }

            // 다음 꽃을 못 찾은 경우
            if (max == 0) {
                System.out.println(0);
                return;
            }
            date = max;
            answer++;
        }
        System.out.println(answer);
    }
}
