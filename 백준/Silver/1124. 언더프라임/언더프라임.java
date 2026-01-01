import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = A; i <= B; i++) {
            int cnt = countPrimeFactors(i);
            if (cnt >= 2 && isPrime(cnt)) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    private static int countPrimeFactors(int n) {
        int cnt = 0;
        int x = n;

        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                cnt++;
                x /= i;
            }
        }

        if (x > 1) cnt++;
        return cnt;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
