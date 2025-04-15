import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                map.put(name, state);
            } else {
                map.remove(name);
            }
        }

        for (String name : map.keySet()) {
            System.out.println(name);
        }
    }
}
