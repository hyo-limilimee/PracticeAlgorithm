import java.io.*;
import java.util.*;

public class Main {
    static int n, w, l;
    static int[] trucks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 다리를 건너는 트럭의 수
        w = Integer.parseInt(st.nextToken());   // 다리의 길이
        l = Integer.parseInt(st.nextToken());   // 다리의 최대 하중

        trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // 무게, 나가는 시간
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        int time = 0, idx = 0, curWeight = 0;

        // 올려야 할 트럭이 남아 있는 경우 or 다리 위에 아직 트럭이 있는 경우
        while (idx < n || !bridge.isEmpty()) {
            time++;

            // 가장 앞에 있는 트럭이 나가는 시간인 경우
            if (!bridge.isEmpty() && bridge.peekFirst()[1] == time) {
                curWeight -= bridge.poll()[0];
            }

            // 올릴 트럭이 남아있는 경우 && 하중 넘지 않는 경우 && 다리 길이 넘지 않는 경우
            if (idx < n && curWeight + trucks[idx] <= l && bridge.size() < w) {
                curWeight += trucks[idx];
                bridge.offer(new int[]{trucks[idx], time + w});
                idx++;
            }
        }
        System.out.println(time);
    }
}
