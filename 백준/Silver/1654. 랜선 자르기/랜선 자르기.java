import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());   // 이미 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선의 개수

        arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
