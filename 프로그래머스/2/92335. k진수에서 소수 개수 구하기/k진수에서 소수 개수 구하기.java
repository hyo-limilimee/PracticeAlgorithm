import java.util.*;

class Solution {

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        String num = sb.reverse().toString();
        String[] candidates = num.split("0");

        for (int i = 0; i < candidates.length; i++) {
            if (!candidates[i].isEmpty()) {
                long number = Long.parseLong(candidates[i]);
                if (isPrime(number)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
