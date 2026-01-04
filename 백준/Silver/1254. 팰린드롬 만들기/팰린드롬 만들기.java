import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1;
            boolean ok = true;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    ok = false;
                    break;
                }

                left++;
                right--;
            }

            if (ok) {
                System.out.println(n + i);
                return;
            }

        }
    }
}
