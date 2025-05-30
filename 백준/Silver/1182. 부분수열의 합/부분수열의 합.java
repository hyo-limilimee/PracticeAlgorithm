import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSum(0, 0);
        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void makeSum(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        makeSum(index + 1, sum + arr[index]); // 현재 수 포함
        makeSum(index + 1, sum);            // 현재 수 미포함
    }
}
