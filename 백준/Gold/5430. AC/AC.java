import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<Integer> dq = new LinkedList<>();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            if (!arrStr.isEmpty()) {
                String[] elements = arrStr.split(",");
                for (String element : elements) {
                    dq.offer(Integer.parseInt(element));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (dq.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }
            if (!isError) {
                sb.append("[");
                while (!dq.isEmpty()) {
                    sb.append(isReversed ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
