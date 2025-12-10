import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isExcluded = new boolean[1002];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(st.nextToken());
                isExcluded[num] = true;
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int x = 1; x <= 1001; x++) {
            if (isExcluded[x]) continue;

            for (int y = 1; y <= 1001; y++) {
                if (isExcluded[y]) continue;

                int xy = x * y;
                if (xy > N && (xy - N) > minDiff) {
                    break;
                }

                for (int z = 1; z <= 1001; z++) {
                    if (isExcluded[z]) continue;

                    int val = xy * z;
                    int diff = Math.abs(N - val);

                    if (diff < minDiff) {
                        minDiff = diff;
                    }

                    if (minDiff == 0) {
                        System.out.println(0);
                        return;
                    }

                    if (val > N && (val - N) > minDiff) {
                        break;
                    }
                }
            }
        }

        System.out.println(minDiff);

    }
}
