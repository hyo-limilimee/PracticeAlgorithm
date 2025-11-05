import java.io.*;

public class Main {
    static int N;
    static int[][] candies;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candies = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                Character ch = line.charAt(j);

                if (ch == 'C') candies[i][j] = 1;
                else if (ch == 'P') candies[i][j] = 2;
                else if (ch == 'Z') candies[i][j] = 3;
                else if (ch == 'Y') candies[i][j] = 4;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check(candies);
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check(candies);
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        int temp = candies[x2][y2];
        candies[x2][y2] = candies[x1][y1];
        candies[x1][y1] = temp;
    }

    private static void check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int rowCnt = 1;

            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) rowCnt++;
                else rowCnt = 1;
                max = Math.max(rowCnt, max);
            }
        }

        for (int j = 0; j < N; j++) {
            int colCount = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i][j] == arr[i - 1][j]) colCount++;
                else colCount = 1;
                max = Math.max(max, colCount);
            }
        }
    }
}
