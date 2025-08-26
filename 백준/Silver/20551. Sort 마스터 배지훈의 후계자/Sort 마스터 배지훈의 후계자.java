import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new long[N];

        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            A[i] = val;
        }
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long D = Long.parseLong(br.readLine());
            sb.append(binarySearch(D)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(long target) {
        int low = 0;
        int high = N - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
