import java.io.*;
import java.util.*;

public class P_13022_늑대와_올바른_단어 {
    static HashSet<String> rightWords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        init();

        if (check(input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void init() {
        rightWords = new HashSet<>();
        for (int i = 1; i < 13; i++) {
            String sb = "w".repeat(i) +
                    "o".repeat(i) +
                    "l".repeat(i) +
                    "f".repeat(i);
            rightWords.add(sb);
        }
    }

    private static boolean check(String word) {
        if (word.length() < 4) return false;
        if (rightWords.contains(word)) return true;

        int state = 0;
        char[] c = {'w', 'o', 'l', 'f'};
        int prev = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != c[state] && word.charAt(i) != c[(state + 1) % 4]) {
                return false;
            } else if (word.charAt(i) == c[(state + 1) % 4]) {
                state = (state + 1) % 4;
                if (state == 0) {
                    String prevWord = word.substring(prev, i);
                    if (!rightWords.contains(prevWord)) return false;
                    prev = i;
                }
            }
        }
        return rightWords.contains(word.substring(prev));
    }
}
