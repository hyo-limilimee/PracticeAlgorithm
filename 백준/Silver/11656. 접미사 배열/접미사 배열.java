import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        List<String> list = new ArrayList<>();
        list.add(S);

        int n = S.length();
        for (int i = 1; i < n; i++) {
            String str = S.substring(i, n);
            list.add(str);
        }
        Collections.sort(list);

        for(String str : list) System.out.println(str);
    }
}
