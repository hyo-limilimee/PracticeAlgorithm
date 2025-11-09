import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dist, price;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        long minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            total += minPrice * dist[i];

            if (price[i + 1] < minPrice) {
                minPrice = price[i + 1];
            }
        }
        System.out.println(total);
    }
}
