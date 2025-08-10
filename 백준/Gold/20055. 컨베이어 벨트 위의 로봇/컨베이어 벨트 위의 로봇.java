import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] hasRobot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N + 1];
        hasRobot = new boolean[2 * N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;

            rotate();
            moveRobots();
            putRobots();

            if (countZero() >= K) break;
        }

        System.out.println(step);
    }

    static void rotate() {
        int lastDurability = A[2 * N];
        boolean lastRobot = hasRobot[2 * N];

        for (int i = 2 * N; i > 1; i--) {
            A[i] = A[i - 1];
            hasRobot[i] = hasRobot[i - 1];
        }
        A[1] = lastDurability;
        hasRobot[1] = lastRobot;

        if (hasRobot[N]) hasRobot[N] = false;
    }

    static void moveRobots() {
        for (int i = N - 1; i >= 1; i--) {
            if (hasRobot[i] && !hasRobot[i + 1] && A[i + 1] > 0) {
                A[i + 1]--;
                hasRobot[i] = false;
                hasRobot[i + 1] = true;
            }
        }

        if (hasRobot[N]) hasRobot[N] = false;
    }

    static void putRobots() {
        if (A[1] > 0 && !hasRobot[1]) {
            hasRobot[1] = true;
            A[1]--;
        }
    }

    static int countZero() {
        int cnt = 0;
        for (int i = 1; i <= 2 * N; i++) {
            if (A[i] == 0) cnt++;
        }
        return cnt;
    }
}
