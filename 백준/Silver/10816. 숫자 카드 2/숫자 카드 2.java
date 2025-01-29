import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            int cnt = upperBound(cards, search) - lowerBound(cards, search);
            sb.append(cnt).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int lowerBound(int[] arr, int search) {
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= search){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int search) {
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > search){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
