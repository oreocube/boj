import java.io.*;
import java.util.*;

public class P_15663_N과M_9 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recur(0, new ArrayList<>());
        System.out.print(sb);
    }

    private static void recur(int k, ArrayList<Integer> selected) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected.get(i)).append(' ');
            }
            sb.append('\n');
            return;
        }

        int last = 0;
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            if (arr[i] == last) continue;
            last = arr[i];
            used[i] = true;
            selected.add(arr[i]);
            recur(k + 1, selected);
            selected.remove(selected.size() - 1);
            used[i] = false;
        }
    }
}
