import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
            } else if (operation.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (operation.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (operation.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (operation.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    int x = queue.poll();
                    sb.append(x).append("\n");
                    queue.addFirst(x);
                }
            } else if (operation.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    int x = queue.pollLast();
                    sb.append(x).append("\n");
                    queue.offer(x);
                }
            }
        }
        System.out.println(sb);
    }
}

