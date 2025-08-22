import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i];
        }
        System.out.println((int) Math.round((double) sum / N));

        System.out.println(arr[N/2]);

        int[] count = new int[8001];
        int maxFeq = 0;
        for(int num : arr){
            count[num + 4000]++;
            maxFeq = Math.max(maxFeq, count[num + 4000]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 8001; i++){
            if(count[i] == maxFeq){
                list.add(i - 4000);
            }
        }
        Collections.sort(list);

        int mode = (list.size() > 1) ? list.get(1) : list.get(0);
        System.out.println(mode);

        System.out.println(arr[N-1] - arr[0]);
    }
}
