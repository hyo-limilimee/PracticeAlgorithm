import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] sel;
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

        Arrays.sort(arr);  // 사전 순 출력을 위해 정렬
        dfs(0);
        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(sel[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            sel[depth] = arr[i];
            dfs(depth + 1);  // 중복 선택 허용
        }
    }
}
