import java.util.*;
import java.io.*;

public class Main {
    static int[][] wheels = new int[4][8];
    static int[] startIdx = new int[4];
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) wheels[i][j] = line.charAt(j) - '0';
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                visited[j] = false;
            }
            rotate(num - 1, direction);
        }
        System.out.println(calculateScore());
    }

    private static void rotate(int index, int direction) {
        if (index < 0 || index > 3) {
            return;
        }

        visited[index] = true;

        // 왼쪽 비교
        if (index > 0 && !visited[index - 1]) {
            int leftIdx = (startIdx[index] + 6) % 8;
            int prevRight = (startIdx[index - 1] + 2) % 8;
            if (wheels[index][leftIdx] != wheels[index - 1][prevRight]) {
                rotate(index - 1, -direction);
            }
        }

        // 오른쪽 비교
        if (index < 3 && !visited[index + 1]) {
            int rightIdx = (startIdx[index] + 2) % 8;
            int nextLeft = (startIdx[index + 1] + 6) % 8;
            if (wheels[index][rightIdx] != wheels[index + 1][nextLeft]) {
                rotate(index + 1, -direction);
            }
        }

        // 실제 회전
        if (direction == 1) startIdx[index] = (startIdx[index] + 7) % 8;
        else startIdx[index] = (startIdx[index] + 1) % 8;
    }

    private static int calculateScore() {
        int score = 0;

        // 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        if (wheels[0][startIdx[0]] == 1) score += 1;
        // 2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        if (wheels[1][startIdx[1]] == 1) score += 2;
        // 3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        if (wheels[2][startIdx[2]] == 1) score += 4;
        // 4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
        if (wheels[3][startIdx[3]] == 1) score += 8;

        return score;
    }
}
