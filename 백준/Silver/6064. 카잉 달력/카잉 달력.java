import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int M, N, x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int a = 1;
            int b = 1;

            int lcm = lcm(M, N);
            int answer = -1;

            for (int k = x; k <= lcm; k += M) {
                if (k % N == 0) {
                    b = N;
                } else {
                    b = k % N;
                }

                if (b == y) {
                    answer = k;
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
