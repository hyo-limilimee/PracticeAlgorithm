import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int start = 1, end = 2;
        boolean found = false;

        while (start < end) {
            long diff = (long) end * end - (long) start * start;

            if (diff == G) {
                found = true;
                System.out.println(end);
                start++;
            } else if (diff < G) {
                end++;
            } else {
                start++;
            }

            if (end > 100000) break;

        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
