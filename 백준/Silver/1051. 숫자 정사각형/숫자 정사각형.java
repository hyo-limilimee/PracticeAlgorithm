import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int k = Math.min(N, M); k >= 0; k--) {
            for (int i = 0; i + k < N; i++) {
                for (int j = 0; j + k < M; j++) {
                    int p = arr[i][j];
                    if (arr[i + k][j] == p && arr[i][j + k] == p && arr[i + k][j + k] == p) {
                        System.out.println((k + 1) * (k + 1));
                        return;
                    }
                }
            }
        }
    }
}
