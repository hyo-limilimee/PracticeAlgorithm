import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> A = new TreeSet<>();
        HashSet<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        TreeSet<Integer> result = new TreeSet<>();
        for (int x : A) {
            if (!B.contains(x)) {
                result.add(x);
            }
        }

        if (result.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(result.size()).append("\n");
            for (int x : result) {
                sb.append(x).append(" ");
            }
            System.out.println(sb);
        }
    }
}
