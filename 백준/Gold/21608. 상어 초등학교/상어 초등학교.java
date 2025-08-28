import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] room;
    static int[][] like;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N + 1][N + 1];
        like = new int[N * N + 1][4];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                like[student][j] = Integer.parseInt(st.nextToken());
            }
            designateSeat(student);
        }
        System.out.println(calcSatisfaction());
    }

    static void designateSeat(int student) {
        int bestR = -1, bestC = -1;
        int bestLike = -1, bestEmpty = -1;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (room[r][c] != 0) continue;

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    if (nx < 1 || ny < 1 || nx > N || ny > N) continue;

                    if (room[nx][ny] == 0) emptyCnt++;
                    else if (isLiked(student, room[nx][ny])) likeCnt++;
                }

                if (likeCnt > bestLike
                        || (likeCnt == bestLike && emptyCnt > bestEmpty)
                        || (likeCnt == bestLike && emptyCnt == bestEmpty && r < bestR)
                        || (likeCnt == bestLike && emptyCnt == bestEmpty && r == bestR && c < bestC)
                ) {
                    bestR = r;
                    bestC = c;
                    bestLike = likeCnt;
                    bestEmpty = emptyCnt;
                }
            }
        }
        room[bestR][bestC] = student;
    }

    static boolean isLiked(int student, int other) {
        if (other == 0) return false;

        for (int i = 0; i < 4; i++) {
            if (like[student][i] == other) return true;
        }
        return false;
    }

    static int calcSatisfaction() {
        int total = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int s = room[i][j];
                int k = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dx[d];
                    int nc = j + dy[d];
                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                    if (isLiked(s, room[nr][nc])) k++;
                }
                if (k == 1) total += 1;
                else if (k == 2) total += 10;
                else if (k == 3) total += 100;
                else if (k == 4) total += 1000;
            }
        }
        return total;
    }
}
