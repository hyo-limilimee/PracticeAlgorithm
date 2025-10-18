import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] nums = new int[10];

        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';
            if (n == 6) n = 9;
            nums[n]++;
        }

        nums[9] = (nums[9] + 1) / 2;

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = Math.max(answer, nums[i]);
        }
        System.out.println(answer);
    }
}
