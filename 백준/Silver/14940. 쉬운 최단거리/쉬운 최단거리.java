import java.util.*;
import java.io.*;

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        // 목표 지점 좌표
        int destX = 0;
        int destY = 0;

        // 그래프 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 목표 지점인 경우
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    destX = i;
                    destY = j;
                }
            }
        }

        BFS(destX, destY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 도달할 수 없는 위치
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = -1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위를 벗어난 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 이미 방문했거나 방문 할 수 없는 경우
                if (visited[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }

                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;

                arr[nx][ny] = arr[node.x][node.y] + 1;
            }
        }
    }
}
