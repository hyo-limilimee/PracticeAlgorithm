import java.io.*;
import java.util.*;

public class Main {
    static char[] colors = new char[5];
    static int[] numbers = new int[5];
    static int[] numCounts = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            colors[i] = color.charAt(0);
            numbers[i] = num;
            numCounts[num]++;
        }
        Arrays.sort(numbers);

        boolean sameColor = true;
        for (int i = 1; i < 5; i++) {
            if (colors[i] != colors[0]) {
                sameColor = false;
                break;
            }
        }

        boolean consecutive = true;
        for (int i = 1; i < 5; i++) {
            if (numbers[i] != numbers[i - 1] + 1) {
                consecutive = false;
                break;
            }
        }

        int score = 0;

        if (sameColor && consecutive) {
            score = 900 + numbers[4];
        } else if (contains(4)) {
            int num = getNum(4);
            score += 800 + num;
        } else if (contains(3) && contains(2)) {
            int three = getNum(3);
            int two = getNum(2);
            score = 700 + three * 10 + two;
        } else if (sameColor) {
            score = 600 + numbers[4];
        } else if (consecutive) {
            score = 500 + numbers[4];
        } else if (contains(3)) {
            int num = getNum(3);
            score = 400 + num;
        } else if (pairCount() == 2) {
            int high = 0, low = 0;
            for (int i = 9; i >= 1; i--) {
                if (numCounts[i] == 2) {
                    if (high == 0) high = i;
                    else low = i;
                }
            }
            score = 300 + high * 10 + low;
        } else if (contains(2)) {
            int num = getNum(2);
            score = 200 + num;
        } else {
            score = 100 + numbers[4];
        }
        System.out.println(score);
    }

    static boolean contains(int n) {
        for (int i = 1; i <= 9; i++) {
            if (numCounts[i] == n) return true;
        }
        return false;
    }

    static int getNum(int n) {
        for (int i = 1; i <= 9; i++) {
            if (numCounts[i] == n) return i;
        }
        return -1;
    }

    static int pairCount() {
        int c = 0;
        for (int i = 1; i <= 9; i++) {
            if (numCounts[i] == 2) c++;
        }
        return c;
    }
}
