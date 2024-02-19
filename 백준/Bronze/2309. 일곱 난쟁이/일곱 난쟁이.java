import java.io.*;
import java.util.*;

public class Main {
    public static int[] heights;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        heights = new int[9];

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                if (sum - (heights[i] + heights[j]) == 100) {
                    heights[i] = 0;
                    heights[j] = 0;
                    Arrays.sort(heights);

                    for (int k = 2; k < 9; k++) {
                        System.out.println(heights[k]);
                    }
                    return;
                }
            }
        }

    }
}
