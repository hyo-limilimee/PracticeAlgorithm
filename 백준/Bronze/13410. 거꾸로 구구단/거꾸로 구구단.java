import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int i = 1; i <= K; i++){
            int num = N * i;
           StringBuilder sb = new StringBuilder();
           sb.append(num).reverse();
            max = Math.max(max, Integer.parseInt(sb.toString()));
        }
        System.out.println(max);
    }
}
