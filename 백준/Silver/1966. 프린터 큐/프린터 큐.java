import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] cnt = new int[10];
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, p});
                cnt[p]++;
            }

            int printed = 0;
            int maxP = 9;
            while (maxP > 0 && cnt[maxP] == 0) maxP--;

            while (true) {
                int[] cur = queue.poll();
                int idx = cur[0], pr = cur[1];

                if (pr < maxP) {
                    queue.offer(cur);
                } else {
                    printed++;
                    cnt[pr]--;
                    if (idx == M) {
                        sb.append(printed).append('\n');
                        break;
                    }
                    while (maxP > 0 && cnt[maxP] == 0) maxP--;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
