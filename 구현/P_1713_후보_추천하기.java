import java.io.*;
import java.util.*;

public class P_1713_후보_추천하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] posted = new boolean[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Student> board = new ArrayList<>();

        Comparator<Student> comp = Comparator.<Student>comparingInt(o -> o.count).thenComparingInt(o -> o.order);
        for (int i = 0; i < m; i++) {
            int id = Integer.parseInt(st.nextToken());
            if (!posted[id]) {
                if (board.size() == n) {
                    board.sort(comp);
                    posted[board.remove(0).id] = false;
                }
                posted[id] = true;
                board.add(new Student(id, i));
            } else {
                for (Student s : board) {
                    if (s.id == id) {
                        s.count++;
                        break;
                    }
                }
            }
        }

        board.sort(Comparator.comparingInt(o -> o.id));
        StringBuilder sb = new StringBuilder();
        for (Student s : board) sb.append(s.id).append(' ');
        System.out.println(sb);
    }
}

class Student {
    int id, count, order;

    Student(int id, int order) {
        this.id = id;
        this.count = 1;
        this.order = order;
    }
}
