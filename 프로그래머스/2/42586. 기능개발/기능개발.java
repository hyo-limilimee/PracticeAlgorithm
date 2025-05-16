import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int index = 0; // 진행 상태
        int n = progresses.length;
        
        // 작업이 끝날 때까지 반복
        while (index < n) {
            // 각 작업 진도 업데이트
            for (int i = 0; i < n; i++) {
                progresses[i] += speeds[i];
            }

            // 한 번에 배포되는 작업 개수를 세기
            int count = 0;
            while (index < n && progresses[index] >= 100) {
                count++;
                index++;
            }

            // 배포된 작업이 있으면 추가
            if (count > 0) {
                ans.add(count);
            }
        }

        // List를 배열로 변환하여 반환
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
