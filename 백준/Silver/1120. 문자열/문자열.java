import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int a = A.length();
        int b = B.length();
        int answer = Integer.MAX_VALUE;

        for (int s = 0; s <= b - a; s++) {
            int diff = 0;

            for (int i = 0; i < a; i++) {
                if (A.charAt(i) != B.charAt(s + i)) {
                    diff++;
                }
            }

            answer = Math.min(answer, diff);
        }

        System.out.println(answer);
    }
}
