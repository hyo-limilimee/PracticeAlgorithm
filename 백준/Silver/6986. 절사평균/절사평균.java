import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[] scores = new double[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(scores);

        double sum = 0.0;
        for (int i = K; i < N - K; i++) {
            sum += scores[i];
        }
        double trimmedAvg = sum / (N - 2 * K);
        trimmedAvg = Math.round(trimmedAvg * 100) / 100.0;
        System.out.printf("%.2f\n", trimmedAvg);

        double[] adjusted = scores.clone();

        for (int i = 0; i < K; i++) {
            adjusted[i] = scores[K];
        }

        for (int i = N - K; i < N; i++) {
            adjusted[i] = scores[N - K - 1];
        }

        sum = 0.0;
        for (double v : adjusted) {
            sum += v;
        }

        double adjustedAvg = sum / N;
        adjustedAvg = Math.round(adjustedAvg * 100) / 100.0;
        System.out.printf("%.2f\n", adjustedAvg);
    }
}
