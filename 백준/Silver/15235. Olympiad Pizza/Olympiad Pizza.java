import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int slices = Integer.parseInt(st.nextToken());
            queue.add(new int[]{i, slices});
        }

        int[] answer = new int[N];
        int time = 0;

        while (!queue.isEmpty()) {
            time++;
            int[] curr = queue.poll();
            int idx = curr[0];
            int remained = --curr[1];

            if (remained == 0) {
                answer[idx] = time;
            } else {
                queue.add(new int[]{idx, remained});
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
