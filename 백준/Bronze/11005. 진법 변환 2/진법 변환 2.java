import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int r = (int)(N % B);

            if (r < 10) {
                sb.append((char) ('0' + r));
            } else {
                sb.append((char) ('A' + (r - 10)));
            }

            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }
}
