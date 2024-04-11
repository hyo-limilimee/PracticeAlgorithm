import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 배열에 입력 받기
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬 하기
        Collections.sort(arr);

        // 가장 짧은 것 부터 하나씩 연결
        int cnt = 0;
        while (true) {
            if (arr.size() <= 1) {
                break;
            }

            arr.set(0, arr.get(0) - 1);
            arr.remove(arr.size() - 1);

            if (arr.get(0) == 0) {
                arr.remove(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
