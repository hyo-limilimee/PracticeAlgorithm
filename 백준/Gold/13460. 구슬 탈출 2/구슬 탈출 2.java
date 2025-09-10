import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Marble {
    int rx, ry, bx, by, count;

    public Marble(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Marble initial;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        sc.close();

        initial = new Marble(rx, ry, bx, by, 0);
        System.out.println(bfs());
    }
    
    // 특정 방향으로 구슬을 이동시키는 함수
    static int[] move(int x, int y, int d) {
        int nx = x;
        int ny = y;
        while (board[nx][ny] != '#' && board[nx][ny] != 'O') {
            nx += dx[d];
            ny += dy[d];
        }
        if (board[nx][ny] == '#') {
            nx -= dx[d];
            ny -= dy[d];
        }
        return new int[]{nx, ny};
    }

    static int bfs() {
        Queue<Marble> q = new LinkedList<>();
        q.add(initial);
        visited[initial.rx][initial.ry][initial.bx][initial.by] = true;

        while (!q.isEmpty()) {
            Marble current = q.poll();

            if (current.count >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int[] nextR = move(current.rx, current.ry, i);
                int[] nextB = move(current.bx, current.by, i);

                int nrx = nextR[0], nry = nextR[1];
                int nbx = nextB[0], nby = nextB[1];

                if (board[nbx][nby] == 'O') {
                    continue; // 파란 구슬이 구멍에 빠지면 실패
                }
                
                if (board[nrx][nry] == 'O') {
                    return current.count + 1; // 빨간 구슬만 구멍에 빠지면 성공
                }

                // 두 구슬이 겹치는 경우 위치 조정
                if (nrx == nbx && nry == nby) {
                    // 벽에 더 가까운 구슬을 판단하여 위치 조정
                    int redDist = Math.abs(current.rx - nrx) + Math.abs(current.ry - nry);
                    int blueDist = Math.abs(current.bx - nbx) + Math.abs(current.by - nby);

                    if (redDist > blueDist) { // 빨간 구슬이 더 멀리 이동했다면, 파란 구슬 뒤에 있었던 것
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else { // 파란 구슬이 더 멀리 이동했다면
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }
                
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new Marble(nrx, nry, nbx, nby, current.count + 1));
                }
            }
        }
        return -1;
    }
}