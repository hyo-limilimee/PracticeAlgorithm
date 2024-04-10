import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int count;
    boolean isGram;

    public Node(int x, int y, int count, boolean isGram) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isGram = isGram;
    }
}

public class Main {
    static int N;
    static int M;
    static int T;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);
        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.count > T) {
                break;
            }

            if (node.x == N - 1 && node.y == M - 1) {
                return node.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 그람이 없을 때
                    if (!node.isGram) {
                        if (!visited[nx][ny][0] && arr[nx][ny] == 0) {
                            queue.add(new Node(nx, ny, node.count + 1, false));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && arr[nx][ny] == 2) {
                            queue.add(new Node(nx, ny, node.count + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    }

                    // 그람 있을 때
                    else {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.add(new Node(nx, ny, node.count + 1, true));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
