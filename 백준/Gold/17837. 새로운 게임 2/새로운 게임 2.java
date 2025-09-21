import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] arr;
    static int[][] horses;
    static List<Integer>[][] pieces;
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};
    static int turn = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        pieces = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pieces[i][j] = new ArrayList<>();
            }
        }

        // 흰 : 0, 빨 : 1, 노 : 2
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        horses = new int[K + 1][3];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            horses[i][0] = row;
            horses[i][1] = col;
            horses[i][2] = dir;
            pieces[row][col].add(i);
        }

        while (turn <= 1000) {
            turn++;
            for (int i = 1; i <= K; i++) {
                if (move(i)) {
                    System.out.println(turn);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static boolean move(int idx) {
        int r = horses[idx][0];
        int c = horses[idx][1];
        int d = horses[idx][2];

        List<Integer> cell = pieces[r][c];  // 현재 칸에 있는 말 리스트
        int startIdx = cell.indexOf(idx);
        List<Integer> moving = new ArrayList<>(cell.subList(startIdx, cell.size()));
        pieces[r][c] = new ArrayList<>(cell.subList(0, startIdx));  // 남은 말들

        int nr = r + dr[d];
        int nc = c + dc[d];

        // 범위 밖 or 파랑
        if (nr < 1 || nr > N || nc < 1 || nc > N || arr[nr][nc] == 2) {
            d = reverseDir(d);
            horses[idx][2] = d;
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 1 || nr > N || nc < 1 || nc > N || arr[nr][nc] == 2) {
                // 이동 불가 → 제자리 복구
                pieces[r][c].addAll(moving);
                return false;
            }
        }

        // 색 처리
        if (arr[nr][nc] == 1) Collections.reverse(moving);

        // 이동 적용
        for (int horse : moving) {
            horses[horse][0] = nr;
            horses[horse][1] = nc;
        }
        pieces[nr][nc].addAll(moving);

        return pieces[nr][nc].size() >= 4;
    }


    static int reverseDir(int d) {
        if (d == 1) return 2;
        if (d == 2) return 1;
        if (d == 3) return 4;
        return 3;
    }
}
