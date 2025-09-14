import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;     // 주어진 N개의 수
    static int[] sel;     // 선택된 M개의 수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.print(sb.toString());
    }

    // depth: 지금까지 선택한 수 개수
    // start: 다음 선택 가능한 인덱스 (오름차순 + 중복 방지)
    static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(sel[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++) {
            sel[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
