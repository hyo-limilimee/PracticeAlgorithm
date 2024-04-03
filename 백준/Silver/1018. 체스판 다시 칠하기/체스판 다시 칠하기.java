import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;   // white
                } else {
                    arr[i][j] = false;  // black
                }
            }
        }

        // 자를 칸 기준(첫 번째 칸) 탐색
        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        // 8X8 끝 점 표기
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // 첫 번째 칸의 색
        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색이 아닐 경우 count 1 증가
                if (arr[i][j] != TF) {
                    count++;
                }
                //다음 칸은 색이 바뀌므로 true라면 false로, false 라면 true로 변경
                TF = (!TF);
            }
            TF = !TF;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
