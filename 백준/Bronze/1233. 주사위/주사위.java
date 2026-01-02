import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주사위 면의 개수 입력
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();

        // 합의 빈도를 저장할 배열 (최대 합: 20 + 20 + 40 = 80)
        int[] counts = new int[81];

        // 모든 조합에 대해 합 계산 및 빈도 증가
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    counts[i + j + k]++;
                }
            }
        }

        int maxFreq = 0;
        int answer = 0;

        // 가장 높은 빈도를 가진 합 찾기
        // 작은 합부터 순회하므로 빈도가 같을 경우 자동으로 작은 값이 유지됨
        for (int i = 3; i <= 80; i++) {
            if (counts[i] > maxFreq) {
                maxFreq = counts[i];
                answer = i;
            }
        }

        System.out.println(answer);
        sc.close();
    }
}