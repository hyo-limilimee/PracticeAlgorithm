import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] scores = new int[8][2];
        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i][0] = score;
            scores[i][1] = i;
        }

        Arrays.sort(scores, (a, b) -> b[0] - a[0]);
        int sum = 0;
        int[] idx = new int[5];

        for (int i = 0; i < 5; i++) {
            sum += scores[i][0];
            idx[i] = scores[i][1] + 1;
        }

        Arrays.sort(idx);
        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            System.out.print(idx[i] + " ");
        }
    }
}
