import java.io.*;
import java.util.*;

public class Main {
    static class FireBall {
        int r, c, m, d, s;

        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static List<FireBall> list = new ArrayList<>();
    static ArrayList<FireBall>[][] grid;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 격자 : N * N
        M = Integer.parseInt(st.nextToken());   // 파이어 볼 개수
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new FireBall(r, c, m, s, d));
        }

        grid = new ArrayList[N][N];

        for (int i = 0; i < K; i++) {
            move();
            mergeAndSplit();
        }

        long sum = 0;
        for (FireBall fb : list) sum += fb.m;
        System.out.println(sum);
    }


    static void move() {
        ArrayList<FireBall>[][] newGrid = new ArrayList[N][N];

        for (FireBall fb : list) {
            int s = fb.s % N; // 토러스 최적화

            int nr = (fb.r + dr[fb.d] * s) % N;
            int nc = (fb.c + dc[fb.d] * s) % N;
            // 음수 모듈러 보정
            if (nr < 0) nr += N;
            if (nc < 0) nc += N;

            if (newGrid[nr][nc] == null) newGrid[nr][nc] = new ArrayList<>();
            newGrid[nr][nc].add(new FireBall(nr, nc, fb.m, fb.s, fb.d));
        }
        grid = newGrid;
    }

    static void mergeAndSplit() {
        List<FireBall> next = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 각 칸에 있는 리스트
                ArrayList<FireBall> cell = grid[r][c];
                if (cell == null || cell.isEmpty()) continue;

                if (cell.size() == 1) {
                    next.add(cell.get(0));
                    continue;
                }

                int sumM = 0, sumS = 0;
                boolean allEven = true, allOdd = true;
                for (FireBall fb : cell) {
                    sumM += fb.m;
                    sumS += fb.s;
                    if (fb.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }
                // 질량
                int newM = sumM / 5;
                if (newM == 0) continue; // 소멸

                // 속력
                int newS = sumS / cell.size();
                int[] dirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                for (int d : dirs) next.add(new FireBall(r, c, newM, newS, d));
            }
        }

        list = next;
    }
}
