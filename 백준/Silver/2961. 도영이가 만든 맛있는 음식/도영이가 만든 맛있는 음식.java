import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());   // 재료의 개수

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);   //트리 깊이, 신 맛, 쓴 맛, 선택한 음식 개수
        System.out.println(answer);
    }

    private static void dfs(int level, int s, int b, int selectedCount) {
        // 완전 탐색
        if (level == N) {
            if (selectedCount != 0 && Math.abs(s - b) < answer) {
                answer = Math.abs(s - b);
            }
            return;
        }
        dfs(level + 1, s * S[level], b + B[level], selectedCount + 1);  // 재료 넣은 것
        dfs(level + 1, s, b, selectedCount); // 재료 안 넣은 것
    }
}
