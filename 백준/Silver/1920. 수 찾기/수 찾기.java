import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            int result = binarySearch(nums, N, search);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] nums, int N, int search) {
        int left = 0;
        int right = N - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == search) {
//                sb.append(1).append('\n');
                return 1;
            } else if (nums[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
//        sb.append(0).append('\n');
    }
}