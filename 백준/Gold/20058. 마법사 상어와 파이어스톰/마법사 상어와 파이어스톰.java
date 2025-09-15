import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, n, L;
    static int[][] A;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        n = 1;
        for (int i = 0; i < N; i++) n *= 2;
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L = Integer.parseInt(st.nextToken());
            int l = 1;
            for (int j = 0; j < L; j++) l *= 2;
            split(l);
            find();
        }

        int sum = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sum += A[r][c];
            }
        }
        System.out.println(sum);

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][] visited = new boolean[n][n];
        int maxSize = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (A[r][c] > 0 && !visited[r][c]) {
                    int size = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{r, c});
                    visited[r][c] = true;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        size++;

                        for (int d = 0; d < 4; d++) {
                            int nr = curr[0] + dr[d];
                            int nc = curr[1] + dc[d];

                            if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                                if (!visited[nr][nc] && A[nr][nc] > 0) {
                                    visited[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    static void split(int l) {
        for (int r = 0; r < n; r += l) {
            for (int c = 0; c < n; c += l) {
                rotate(r, c, l);
            }
        }
    }

    static void rotate(int r, int c, int l) {
        int[][] temp = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                temp[j][l - 1 - i] = A[r + i][c + j];
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                A[r + i][c + j] = temp[i][j];
            }
        }
    }

    static void find() {
        List<int[]> melt = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (A[r][c] == 0) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (0 <= nr && nr < n && 0 <= nc && nc < n && A[nr][nc] > 0) {
                        cnt++;
                    }
                }

                if (cnt < 3) {
                    melt.add(new int[]{r, c});
                }
            }
        }

        for (int[] m : melt) {
            A[m[0]][m[1]]--;
        }
    }
}
