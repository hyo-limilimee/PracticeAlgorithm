import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);

        M = Long.parseLong(br.readLine());

        if (sum <= M) {
            System.out.println(arr[N - 1]);
            return;
        }

        binarySearch();
    }

    static void binarySearch() {
        long low = 0;
        long high = arr[N - 1];
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long requiredSum = 0;
            for (long request : arr) {
                requiredSum += Math.min(request, mid);
            }

            if (requiredSum <= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
