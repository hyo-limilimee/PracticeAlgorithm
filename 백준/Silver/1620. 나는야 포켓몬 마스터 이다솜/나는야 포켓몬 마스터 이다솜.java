import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str,i);
        }

        for(int i = 0; i< M; i++){
            String s = br.readLine();
            if(49 <= s.charAt(0) && s.charAt(0) <= 57){
                System.out.println(map1.get(Integer.parseInt(s)));
            }
            else{
                System.out.println(map2.get(s));
            }
        }

    }
}
