import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            } else {
                map.put(title, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String maxTitle = "";
        for (String t : map.keySet()) {
            int cnt = map.get(t);
            if (cnt > max) {
                max = cnt;
                maxTitle = t;
            } else if (cnt == max) {
                for (int i = 0; i < t.length(); i++) {
                    if (t.compareTo(maxTitle) < 0) {
                        maxTitle = t;
                        break;
                    }
                }
            }
        }

        System.out.println(maxTitle);
    }
}
