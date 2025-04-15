import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        TreeMap<String, Integer> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String fileName = st.nextToken();
            String ext = st.nextToken();

            if (map.containsKey(ext)) {
                map.put(ext, map.get(ext) + 1);
            } else {
                map.put(ext, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
