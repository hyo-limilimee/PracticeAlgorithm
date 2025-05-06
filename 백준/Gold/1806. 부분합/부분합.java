import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
