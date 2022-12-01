import java.io.*;

public class P_10988_팰린드롬인지_확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        if (check(word)) System.out.println(1);
        else System.out.println(0);
    }

    static boolean check(char[] word) {
        for (int i = 0; i < word.length / 2; i++) {
            if (word[i] != word[word.length - i - 1]) return false;
        }
        return true;
    }
}
