import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int answer = 0;
        int left = 0;
        int right = arr[N - 1] - arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static boolean canInstall(int dist) {
        int cnt = 1;
        int last = arr[0];

        for (int i = 0; i < N; i++) {
            if (arr[i] - last >= dist) {
                cnt++;
                last = arr[i];
            }
        }
        return cnt >= C;
    }
}
