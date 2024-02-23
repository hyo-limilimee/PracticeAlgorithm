import java.io.*;
import java.util.*;

public class Main {
    public static int cnt;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[21];
        cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers, 0, S, 0);

        if (S == 0) {
            System.out.println(cnt - 1);
            return;
        }
        System.out.println(cnt);
    }

    public static void dfs(int[] numbers, int depth, int target, int sum) {
        // 마지막 노드까지 탐색한 경우
        if (depth == N) {
            if (target == sum) {
                cnt++;
            }
            return;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum);
        }

    }

}
