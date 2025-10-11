import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int cnt = 1;
            int min = arr[0][1];

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < min) {
                    cnt++;
                    min = arr[i][1];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
