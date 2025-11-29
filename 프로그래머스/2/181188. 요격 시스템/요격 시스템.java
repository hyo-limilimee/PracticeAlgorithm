import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 끝점(e) 기준 정렬
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int count = 0;
        double current = -1e9; // 현재 요격 좌표(실수 가능)

        for (int[] t : targets) {
            int s = t[0];
            int e = t[1];

            // 현재 선택된 요격 위치가 이 구간 안에 없으면 새로 쏘기
            if (!(s < current && current < e)) {
                count++;
                current = e - 0.000001; // e보다 아주 조금 작은 점
            }
        }

        return count;
    }
}
