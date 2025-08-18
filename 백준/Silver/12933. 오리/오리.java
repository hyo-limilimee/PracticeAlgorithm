import java.io.*;

public class Main {
    static boolean[] visited;
    static char[] sound;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        visited = new boolean[length];
        sound = str.toCharArray();

        if (length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int duckCnt = 0;

        for (int i = 0; i < length; i++) {
            if (!visited[i] && sound[i] == 'q') {
                char[] pattern = {'q', 'u', 'a', 'c', 'k'};
                int idx = 0;
                boolean started = false;

                for (int j = i; j < length; j++) {
                    if (!visited[j] && sound[j] == pattern[idx]) {
                        visited[j] = true;
                        idx++;

                        if (idx == 5) {
                            idx = 0;
                            started = true;
                        }
                    }
                }

                if (!started) {
                    System.out.println(-1);
                    return;
                }
                duckCnt++;
            }
        }

        for (boolean b : visited) {
            if (!b) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(duckCnt == 0 ? -1 : duckCnt);
    }
}
