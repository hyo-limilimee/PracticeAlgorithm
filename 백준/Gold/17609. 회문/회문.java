import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int left = 0;
            int right = str.length() - 1;
            boolean isPrinted = false;

            while (left < right) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    if (isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1)) {
                        sb.append("1\n");
                    } else {
                        sb.append("2\n");
                    }
                    isPrinted = true;
                    break;
                }
            }
            if (!isPrinted) {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
