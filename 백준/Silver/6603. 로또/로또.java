import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] lotto = new int[6];
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            pickNumber(0, 0);
            System.out.println();
        }
    }

    private static void pickNumber(int index, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < k; i++) {
            lotto[depth] = arr[i];
            pickNumber(i + 1, depth+1);
        }
    }
}
