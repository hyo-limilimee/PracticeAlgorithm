import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] coins = new Integer[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder());

        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            if (K / coins[i] > 0) {
                cnt += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(cnt);
    }
}
