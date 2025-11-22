import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, pack);
            minSingle = Math.min(minSingle, single);
        }

        // 1) 패키지로만 구매 
        int cost1 = (int) Math.ceil(N / 6.0) * minPackage;

        // 2) 패키지 + 낱개 혼합
        int cost2 = (N / 6) * minPackage + (N % 6) * minSingle;

        // 3) 전부 낱개로만 구매
        int cost3 = N * minSingle;

        System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
    }
}
