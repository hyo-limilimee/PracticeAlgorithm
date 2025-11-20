import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 방학 일수 L
        int L = Integer.parseInt(br.readLine());
        // 총 국어 페이지 A
        int A = Integer.parseInt(br.readLine());
        // 총 수학 페이지 B
        int B = Integer.parseInt(br.readLine());
        // 하루 최대 국어 페이지 C
        int C = Integer.parseInt(br.readLine());
        // 하루 최대 수학 페이지 D
        int D = Integer.parseInt(br.readLine());

        // 1. 국어 숙제를 끝내는 데 필요한 최소 일수 계산
        // (A + C - 1) / C 는 A/C를 올림한 것과 같습니다. (A/C의 올림)
        // Math.ceil((double)A / C) 를 사용해도 됩니다.
        int daysForKorean = (A + C - 1) / C;

        // 2. 수학 숙제를 끝내는 데 필요한 최소 일수 계산
        int daysForMath = (B + D - 1) / D;

        // 3. 총 숙제를 끝내는 데 필요한 최소 일수 계산 (더 오래 걸리는 과목 기준)
        int totalMinDays = Math.max(daysForKorean, daysForMath);

        // 4. 놀 수 있는 최대 날의 수
        // 총 방학 일수(L) - 숙제 최소 일수(totalMinDays)
        int maxPlayDays = L - totalMinDays;

        // 결과 출력
        System.out.println(maxPlayDays);
    }
}