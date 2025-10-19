import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int low = 0;
    static long high = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        long answer = high;
        long left = low;
        long right = high;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canCover(mid)) {
                answer = (int) mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) answer;
    }

    static boolean canCover(long K) {
        int withdraws = 0;
        long balance = 0;

        for (int x : arr) {
            if (balance < x) {
                withdraws++;
                balance = K;
            }
            balance -= x;

            if (withdraws > M) return false;
        }
        return true;
    }
}
