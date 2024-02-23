import java.io.*;
import java.util.*;

public class Main {
    public static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   // 필요한 나무 길이

        trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if (max < trees[i]) {
                max = trees[i];
            }
        }

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;

            for (int height : trees) {

                if (height - mid > 0) {
                    sum += (height - mid);
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
