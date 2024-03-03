import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> strList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        for(int i = 0; i <M; i++){
            String str = br.readLine();
            if(set.contains(str)){
                strList.add(str);
            }
        }
        Collections.sort(strList);

        System.out.println(strList.size());

        for(String s: strList){
            System.out.println(s);
        }
    }
}
