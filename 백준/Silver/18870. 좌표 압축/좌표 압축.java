import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static long[] origin, sorted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new long[N];
        sorted = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(st.nextToken());
            origin[i] = val;
            sorted[i] = val;
        }
        Arrays.sort(sorted);

        Map<Long, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i],rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb);
    }
}
