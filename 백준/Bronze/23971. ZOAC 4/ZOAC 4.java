import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테이블이 행마다 W개씩 H행, 세로로 N칸, 가로로 M칸 이상 비우고 앉음
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = ((H - 1) / (N + 1) + 1) * ((W - 1) / (M + 1) + 1);

        System.out.println(answer);
    }
}
