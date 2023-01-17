import java.io.*;
import java.util.*;

public class P_1759_암호_만들기 {
    static StringBuilder resultSb = new StringBuilder();
    static int L, C;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recur(-1, 0,0, new StringBuilder());
        System.out.println(resultSb);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean isValid(int vowelCount) {
        return vowelCount >= 1 && L - vowelCount >= 2;
    }

    private static void recur(int last, int len, int vowelCount, StringBuilder sb) {
        if (len == L) {
            if (isValid(vowelCount)) resultSb.append(sb.toString()).append('\n');
            return;
        }

        for (int i = last + 1; i < C; i++) {
            sb.append(arr[i]);
            if (isVowel(arr[i])) {
                recur(i, len + 1, vowelCount + 1, sb);
            } else {
                recur(i, len + 1, vowelCount, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
