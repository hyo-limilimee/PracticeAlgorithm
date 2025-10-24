import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        Map<Long, Integer> freqMap = new HashMap<>();
        Map<Long, Integer> orderMap = new HashMap<>();
        List<Long> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long v = Long.parseLong(st.nextToken());
            if (!freqMap.containsKey(v)) {
                orderMap.put(v, i);
            }
            freqMap.put(v, freqMap.getOrDefault(v, 0) + 1);
            list.add(v);
        }

        Collections.sort(list, (o1, o2) -> {
            int freq1 = freqMap.get(o1);
            int freq2 = freqMap.get(o2);

            if (freq1 == freq2) {
                return Integer.compare(orderMap.get(o1), orderMap.get(o2));
            }
            return Integer.compare(freq2, freq1);
        });

        StringBuilder sb = new StringBuilder();
        for (long v : list) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}
