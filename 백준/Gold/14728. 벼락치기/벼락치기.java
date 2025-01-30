import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 단원 개수
        int N = Integer.parseInt(st.nextToken());
        // 총 시간
        int T = Integer.parseInt(st.nextToken());
        // 단원 별 예상 공부 시간
        int[] times = new int[N + 1];
        // 단원의 배점
        int[] scores = new int[N + 1];
        // dp
        int[][] dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (j >= times[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + scores[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}
