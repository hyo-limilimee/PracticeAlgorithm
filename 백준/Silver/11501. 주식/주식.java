import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int maxPrice = 0;
            long profit = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < maxPrice) {
                    profit += maxPrice - arr[i];
                } else {
                    maxPrice = arr[i];
                }
            }
            System.out.println(profit);
        }
    }
}
