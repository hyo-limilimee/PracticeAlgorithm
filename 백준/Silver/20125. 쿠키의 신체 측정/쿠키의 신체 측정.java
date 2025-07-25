import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int heartX = -1, heartY = -1;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*' && arr[i + 1][j] == '*') {
                    heartX = i + 1;
                    heartY = j;
                    break;
                }
            }
            if (heartX != -1) break;
        }

        int leftArm = 0;
        for (int y = heartY - 1; y >= 0; y--) {
            if (arr[heartX][y] == '*') leftArm++;
            else break;
        }

        int rightArm = 0;
        for (int y = heartY + 1; y < N; y++) {
            if (arr[heartX][y] == '*') rightArm++;
            else break;
        }

        int waist = 0;
        int waistEndX = heartX;
        for (int x = heartX + 1; x < N; x++) {
            if (arr[x][heartY] == '*') {
                waist++;
                waistEndX = x;
            } else break;
        }

        int leftLeg = 0;
        for (int x = waistEndX + 1; x < N; x++) {
            int y = heartY - 1;
            if (y >= 0 && arr[x][y] == '*') leftLeg++;
            else break;
        }

        int rightLeg = 0;
        for (int x = waistEndX + 1; x < N; x++) {
            int y = heartY + 1;
            if (y < N && arr[x][y] == '*') rightLeg++;
            else break;
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
