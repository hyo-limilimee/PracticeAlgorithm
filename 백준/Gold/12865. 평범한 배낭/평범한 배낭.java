import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N + 1];   // 물건의 무게
        int[] V = new int[N + 1];   // 물건의 가치
        int[][] dp = new int[N + 1][K + 1]; // [물건번호][무게]

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // DP 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j];  // 현재 물건을 담을 수 없을 때
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);  // 물건을 담을 때와 담지 않을 때 중 최댓값
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
