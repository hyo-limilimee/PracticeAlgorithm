import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int[] time = new int[100001];   // 각 위치까지의 최단 시간을 저장하는 배열
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N); // 초기 위치를 큐에 추가
        time[N] = 0;    // 초기 위치까지의 최단 시간 : 0

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 값을 큐에서 제거

            if (current == K) {
                System.out.println(time[current]);
                break;
            }

            // 현재 위치에서의 다음 이동 위치를 계산하여 큐에 추가
            if (current - 1 >= 0 && time[current - 1] == 0) {
                queue.offer(current - 1);
                time[current - 1] = time[current] + 1;
            }

            if (current + 1 <= 100000 && time[current + 1] == 0) {
                queue.offer(current + 1);
                time[current + 1] = time[current] + 1;
            }

            if (current * 2 <= 100000 && time[current * 2] == 0) {
                queue.offer(current * 2);
                time[current * 2] = time[current] + 1;
            }
        }
        sc.close();
    }
}
