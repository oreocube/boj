import java.io.*;
import java.util.*;

public class P_11652_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            int comp = Integer.compare(o2.getValue(), o1.getValue());
            if (comp != 0) return comp;
            return Long.compare(o1.getKey(), o2.getKey());
        });

        System.out.println(list.get(0).getKey());
    }
}
