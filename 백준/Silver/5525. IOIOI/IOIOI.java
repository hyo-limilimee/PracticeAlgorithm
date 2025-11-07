import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String S, pattern;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        pattern = "";
        for (int i = 0; i < 2 * N + 1; i++) {
            if (i % 2 == 0) {
                pattern += "I";
            } else {
                pattern += "O";
            }
        }

        System.out.println(match());
    }

    private static int match() {
        int cnt = 0;
        int len = pattern.length();
        for (int i = 0; i < M - len + 1; i++) {
            String match = S.substring(i, i + len);

            if (match.equals(pattern)) cnt++;
        }
        return cnt;
    }
}
