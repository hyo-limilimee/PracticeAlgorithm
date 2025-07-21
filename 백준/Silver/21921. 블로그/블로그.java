import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        long maxSum = sum;
        int cnt = 1;

        for (int i = X; i < N; i++) {
            sum = sum - arr[i - X] + arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                cnt = 1;
            } else if (sum == maxSum) {
                cnt++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }
}
