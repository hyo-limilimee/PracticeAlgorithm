import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        int max = 0;
        if (type.equals("Y")) {
            max = 1;
        } else if (type.equals("F")) {
            max = 2;
        } else {
            max = 3;
        }

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            set.add(name);
        }

        System.out.println(set.size()/max);
    }
}
