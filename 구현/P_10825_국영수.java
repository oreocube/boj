import java.io.*;
import java.util.*;

public class P_10825_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int ma = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, ko, en, ma);
        }

        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.name).append('\n');
        }
        System.out.print(sb);
    }

    private static class Student implements Comparable<Student> {
        String name;
        int ko, en, ma;

        Student(String name, int ko, int en, int ma) {
            this.name = name;
            this.ko = ko;
            this.en = en;
            this.ma = ma;
        }

        @Override
        public int compareTo(Student o) {
            if (ko != o.ko) return Integer.compare(o.ko, ko);
            if (en != o.en) return Integer.compare(en, o.en);
            if (ma != o.ma) return Integer.compare(o.ma, ma);
            return name.compareTo(o.name);
        }
    }
}
