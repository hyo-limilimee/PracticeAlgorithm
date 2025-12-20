import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            int num = arr[i % N];
            if (cnt[num] == 0) distinct++;
            cnt[num]++;
        }

        int answer = distinct;
        if(cnt[c] == 0) {
            answer++;
        }

        for(int start = 1; start < N; start++){
            int remove = arr[(start - 1) % N];
            cnt[remove]--;
            if(cnt[remove] == 0) distinct--;

            int add = arr[(start + k - 1) % N];
            if(cnt[add] == 0) distinct++;
            cnt[add]++;

            answer = Math.max(answer, distinct + (cnt[c] == 0 ? 1 : 0));
        }
        System.out.println(answer);
    }
}
