import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1, r = 1, c = 1;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x > max) { max = x; r = i; c = j; }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(r).append(' ').append(c);
        System.out.println(sb);
    }
}