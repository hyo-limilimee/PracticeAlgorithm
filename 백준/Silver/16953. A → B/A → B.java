import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long currNum = current[0];
            long cnt = current[1];

            if (currNum == B) {
                System.out.println(cnt);
                return;
            }

            if (currNum * 2 <= B) {
                queue.offer(new long[]{currNum * 2, cnt + 1});
            }
            if (currNum * 10 + 1 <= B) {
                queue.offer(new long[]{currNum * 10 + 1, cnt + 1});
            }
        }

        System.out.println(-1);

    }
}
