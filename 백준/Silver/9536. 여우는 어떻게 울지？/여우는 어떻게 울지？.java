import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(br.readLine());
            List<String> sounds = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            while (st.hasMoreTokens()) sounds.add(st.nextToken());

            while (true) {
                st = new StringTokenizer(br.readLine());

                String first = st.nextToken();
                if (first.equals("what")) break;

                st.nextToken();
                String sound = st.nextToken();
                sounds.removeIf(s -> s.equals(sound));
            }
             for(String str : sounds){
                 sb.append(str).append(" ");
             }
            System.out.println(sb);
        }
    }
}
