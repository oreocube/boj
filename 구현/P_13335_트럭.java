import java.io.*;
import java.util.*;

public class P_13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int sum = 0;
        while (!trucks.isEmpty()) {
            int truck = trucks.peek();
            if (bridge.size() == w) sum -= bridge.poll();
            if (bridge.size() < w && sum + truck <= l) {
                sum += truck;
                bridge.add(trucks.poll());
            } else {
                bridge.add(0);
            }
            time++;
        }
        System.out.println(time + w);
    }
}
