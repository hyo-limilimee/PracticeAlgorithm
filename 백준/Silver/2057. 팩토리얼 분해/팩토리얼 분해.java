import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 0) {
            System.out.println("NO");
            return;
        }

        long[] fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (N >= fact[i]) N -= fact[i];
        }

        if (N == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
