import java.io.*;

public class P_9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "[A-F]?[A]+[F]+[C]+[A-F]?$";
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            if (br.readLine().matches(regex)) {
                sb.append("Infected!\n");
            } else {
                sb.append("Good\n");
            }
        }
        System.out.print(sb);
    }
}
