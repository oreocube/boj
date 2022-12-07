import java.io.*;
import java.util.*;

public class P_1864_문어_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = {'-', '\\', '(', '@', '?', '>', '&', '%'};
        map.put('/', -1);
        for (int i = 0; i < 8; i++) map.put(c[i], i);

        while (true) {
            String number = br.readLine();
            if (number.equals("#")) break;

            int answer = 0;
            for (int i = 0; i < number.length(); i++) {
                int digit = map.get(number.charAt(i));
                int tmp = 1;
                for (int j = 0; j < number.length() - i - 1; j++) tmp *= 8;
                answer += digit * tmp;
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
