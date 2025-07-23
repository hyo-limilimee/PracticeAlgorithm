import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        int cntA = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') {
                cntA++;
            }
        }

        if (cntA == 0 || cntA == n) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = (str.charAt(i) == 'b') ? 1 : 0;
            arr[i + n] = arr[i];
        }

        int current = 0;
        for (int i = 0; i < cntA; i++) {
            current += arr[i];
        }
        int minB = current;

        for (int i = cntA; i < n + cntA; i++) {
            current = current - arr[i - cntA] + arr[i];
            if (current < minB) {
                minB = current;
            }
        }
        System.out.println(minB);
    }
}
