import java.io.*;
import java.util.*;

public class Main {
    static int K, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            if (set.contains(id)) set.remove(id);
            set.add(id);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String id : set) {
            if (count == K) break;
            sb.append(id).append('\n');
            count++;
        }
        System.out.print(sb.toString());
    }
}
