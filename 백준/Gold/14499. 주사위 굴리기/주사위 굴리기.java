import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] arr;
    static int[] dice = new int[7];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 세로 크기
        M = Integer.parseInt(st.nextToken());   // 가로 크기
        x = Integer.parseInt(st.nextToken());   // 주사위 놓은 x
        y = Integer.parseInt(st.nextToken());   // 주사위 놓은 y
        K = Integer.parseInt(st.nextToken());   // 명령의 개수

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(st.nextToken());
            int nx = x + dx[order];
            int ny = y + dy[order];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            x = nx;
            y = ny;
            roll(order);

            if (arr[x][y] == 0) {
                arr[x][y] = dice[6];
            } else {
                dice[6] = arr[x][y];
                arr[x][y] = 0;
            }

            sb.append(dice[1]).append("\n");
        }
        System.out.println(sb);
    }

    static void roll(int order) {
        int[] temp = dice.clone();

        switch (order) {
            case 1: //동
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;

            case 2: //서
                dice[1] = temp[3];
                dice[4] = temp[1];
                dice[6] = temp[4];
                dice[3] = temp[6];
                break;

            case 3: //북
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[6] = temp[2];
                dice[5] = temp[6];
                break;
                
            case 4: //남
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[6] = temp[5];
                dice[5] = temp[1];
        }
    }
}
