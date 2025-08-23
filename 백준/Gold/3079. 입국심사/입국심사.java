import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 입국 심사대 개수
        M = Long.parseLong(st.nextToken());     // 사람 수

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        binarySearch();
    }

    static void binarySearch() {
        long low = 1;
        long high = M * arr[0];
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += mid / arr[i];
                if (count >= M) break;
            }

            if (count >= M) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
