import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final long MOD = 1000000000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] B = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        long answer = gcd(A, B);
        if (answer >= MOD) {
            System.out.printf("%09d\n", answer % MOD);
        } else {
            System.out.println(answer);
        }

    }

    private static long gcd(long[] A, long[] B) {
        long result = 1;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long g = gcd(A[i], B[j]);
                if (g > 1) {
                    result = (result * g) % (MOD * 10);
                    A[i] /= g;
                    B[j] /= g;
                }
            }
        }

        return result;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
