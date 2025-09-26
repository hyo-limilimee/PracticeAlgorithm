import java.io.*;

public class Main {
    static int N;
    static String standard;
    static int[] sArr = new int[26];
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        standard = br.readLine();
        for (int i = 0; i < standard.length(); i++) {
            int s = standard.charAt(i) - 'A';
            sArr[s]++;
        }

        for (int i = 0; i < N - 1; i++) {
            String word = br.readLine();
            if (isSimilar(word)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isSimilar(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'A';
            arr[w]++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += (Math.abs(arr[i] - sArr[i]));
        }
        
        int lenDiff = Math.abs(word.length() - standard.length());

        if (diff == 0) return true; // 완전히 같은 단어
        if (diff == 1 && lenDiff == 1) return true; // 한 글자 추가/삭제
        if (diff == 2 && lenDiff == 0) return true; // 한 글자 교체
        return false;
        
    }
}
