import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }

        return true;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
