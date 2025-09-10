import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int N, M;
    static int rX, rY, bX, bY;
    static char[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                if (ch == 'R') {
                    rX = i;
                    rY = j;
                    arr[i][j] = '.';
                } else if (ch == 'B') {
                    bX = i;
                    bY = j;
                    arr[i][j] = '.';
                } else {
                    arr[i][j] = ch;
                }
            }
        }

        bfs(arr, new State(rX, rY, bX, bY, 0));

    }

    static void bfs(char[][] arr, State state) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.add(state);
        visited[state.rx][state.ry][state.bx][state.by] = true;

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.depth >= 10) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int[] redResult = move(curr.rx, curr.ry, dx[i], dy[i]);
                int redX = redResult[0];
                int redY = redResult[1];
                int redCnt = redResult[2];

                int[] blueResult = move(curr.bx, curr.by, dx[i], dy[i]);
                int blueX = blueResult[0];
                int blueY = blueResult[1];
                int blueCnt = blueResult[2];

                if (arr[blueX][blueY] == 'O') continue;

                if (arr[redX][redY] == 'O') {
                    System.out.println(curr.depth + 1);
                    return;
                }

                if (redX == blueX && redY == blueY) {
                    if (redCnt > blueCnt) {
                        redX -= dx[i];
                        redY -= dy[i];
                    } else {
                        blueX -= dx[i];
                        blueY -= dy[i];
                    }
                }

                if (!visited[redX][redY][blueX][blueY]) {
                    visited[redX][redY][blueX][blueY] = true;
                    queue.add(new State(redX, redY, blueX, blueY, curr.depth + 1));
                }
            }
        }

        if (queue.isEmpty()) System.out.println(-1);
    }

    static int[] move(int x, int y, int dx, int dy) {
        int dist = 0;
        int nx = x;
        int ny = y;

        // 벽이 아니고 구멍이 아닌 경우
        while (arr[nx][ny] != '#' && arr[nx][ny] != 'O') {
            nx += dx;
            ny += dy;
            dist++;

            if (arr[x][y] == 'O') break;
        }

        // 벽을 만난 경우
        if (arr[nx][ny] == '#') {
            nx -= dx;
            ny -= dy;
        }

        return new int[]{nx, ny, dist};
    }

}
