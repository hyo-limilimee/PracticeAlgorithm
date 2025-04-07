import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static int[] picked;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        picked = new int[M];
        pick(0, 0);
        System.out.println(minDist);
    }

    // 폐업 시키지 않을 치킨 집 고르기
    private static void pick(int index, int depth) {
        if (depth == M) {
            calculateDist();
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            picked[depth] = i;
            pick(i + 1, depth + 1);
        }
    }

    // 치킨 거리 구하기
    private static void calculateDist() {
        int dist = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    dist += calculateEachMin(i, j);
                }
            }
        }
        minDist = Math.min(minDist, dist);
    }

    private static int calculateEachMin(int row, int col) {
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < picked.length; i++) {
            int chickenIndex = picked[i];
            int[] chicken = chickens.get(chickenIndex);
            int curDist = Math.abs(row - chicken[0]) + Math.abs(col - chicken[1]);
            dist = Math.min(dist, curDist);
        }

        return dist;
    }
}
