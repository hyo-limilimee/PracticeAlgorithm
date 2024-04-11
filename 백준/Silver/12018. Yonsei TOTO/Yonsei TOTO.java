import java.io.*;
import java.util.*;

public class Main {
    static int[] minArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 과목 수
        int m = Integer.parseInt(st.nextToken());   // 마일리지
        minArr = new int[n];  // minArr 배열 초기화

        for(int i = 0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   // 과목에 신청한 사람 수
            int l = Integer.parseInt(st.nextToken());   // 과목 당 수강 인원

            // 이미 신청한 사람들의 마일리지 리스트
            Integer[] mArr = new Integer[p];    // 내림차순을 위해 int Integer로 생성

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < p; j++){
                mArr[j] = Integer.parseInt(st.nextToken());
            }

            // 기존 신청 인원 < 신청 가능 인원
            if(p < l){
                minArr[i] = 1;
                continue;
            }
            else{
                // 과목별 마일리지 배열 내림차순 정렬
                Arrays.sort(mArr, Collections.reverseOrder());
                minArr[i] = mArr[l-1];
            }
        }

        // 리스트 오름차순 정렬, 누적합 < m 인 갯수 count
        Arrays.sort(minArr);
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += minArr[i];
            if(sum > m){
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
