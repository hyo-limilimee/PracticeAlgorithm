import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] switches, students, numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 스위치 수
        switches = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());    // 학생 수
        students = new int[M];
        numbers = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = Integer.parseInt(st.nextToken());
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (students[i] == 1) {
                operateByBoys(numbers[i]);
            } else {
                operateByGirls(numbers[i]);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static void operateByBoys(int num) {
        for (int i = num; i <= N; i += num) {
            operateSwitch(i);
        }
    }

    static void operateByGirls(int index) {
        int low = index;
        int high = index;

        while (low - 1 >= 1 && high + 1 <= N && switches[low - 1] == switches[high + 1]) {
            low--;
            high++;
        }

        for (int i = low; i <= high; i++) {
            operateSwitch(i);
        }
    }

    static void operateSwitch(int index) {
        if (switches[index] == 0) {
            switches[index] = 1;
        } else {
            switches[index] = 0;
        }
    }
}
