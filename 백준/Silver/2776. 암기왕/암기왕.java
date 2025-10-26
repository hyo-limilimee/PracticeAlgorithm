import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            a = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());
                if (binarySearch(0, N - 1, target)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean binarySearch(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
