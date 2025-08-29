import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int rowCnt = 3, colCnt = 3;
    static int[][] A = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // t=0 체크
        if (r - 1 < rowCnt && c - 1 < colCnt && A[r - 1][c - 1] == k) {
            System.out.println(0);
            return;
        }

        // t=1..100
        for (int time = 1; time <= 100; time++) {
            if (rowCnt >= colCnt) calcR();
            else                 calcC();

            if (r - 1 < rowCnt && c - 1 < colCnt && A[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    // R 연산: 행 단위
    static void calcR() {
        int newCol = 0;

        for (int i = 0; i < rowCnt; i++) {
            int[] freq = new int[101]; // 값 1..100

            // 빈도 계산 (0 제외)
            for (int j = 0; j < colCnt; j++) {
                int v = A[i][j];
                if (v != 0) freq[v]++;
            }

            // (num, cnt) 쌍 수집
            ArrayList<int[]> list = new ArrayList<>();
            for (int num = 1; num <= 100; num++) {
                if (freq[num] > 0) list.add(new int[]{num, freq[num]});
            }

            // 정렬: cnt 오름차순, num 오름차순
            list.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

            // 결과 작성: num, cnt 순서로; 원소 최대 100개
            int L = Math.min(100, list.size() * 2);
            int idx = 0;
            for (int[] p : list) {
                if (idx >= L) break;
                A[i][idx++] = p[0]; // num
                if (idx >= L) break;
                A[i][idx++] = p[1]; // cnt
            }

            // 나머지 0 패딩
            for (int j = idx; j < 100; j++) A[i][j] = 0;

            newCol = Math.max(newCol, L);
        }

        colCnt = Math.min(100, newCol);
    }

    // C 연산: 열 단위
    static void calcC() {
        int newRow = 0;

        for (int j = 0; j < colCnt; j++) {
            int[] freq = new int[101];

            // 빈도 계산 (0 제외)
            for (int i = 0; i < rowCnt; i++) {
                int v = A[i][j];
                if (v != 0) freq[v]++;
            }

            // (num, cnt) 쌍 수집
            ArrayList<int[]> list = new ArrayList<>();
            for (int num = 1; num <= 100; num++) {
                if (freq[num] > 0) list.add(new int[]{num, freq[num]});
            }

            // 정렬: cnt 오름차순, num 오름차순
            list.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

            // 결과 작성: 위→아래로 num, cnt; 원소 최대 100개
            int L = Math.min(100, list.size() * 2);
            int idx = 0;
            for (int[] p : list) {
                if (idx >= L) break;
                A[idx++][j] = p[0]; // num
                if (idx >= L) break;
                A[idx++][j] = p[1]; // cnt
            }

            // 나머지 0 패딩
            for (int i = idx; i < 100; i++) A[i][j] = 0;

            newRow = Math.max(newRow, L);
        }

        rowCnt = Math.min(100, newRow);
    }
}
