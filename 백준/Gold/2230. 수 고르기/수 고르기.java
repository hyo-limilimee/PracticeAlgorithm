import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int start = 0, end = 0;
        int minDiff = Integer.MAX_VALUE;

        while (start < N && end < N) {
            int diff = A[end] - A[start];

            if (diff < M) {
                end++;
            } else if (diff >= M) {
                minDiff = Math.min(diff, minDiff);
                start++;

                if (start == end) {
                    end++;
                }
            }
        }
        System.out.println(minDiff);
    }
}
