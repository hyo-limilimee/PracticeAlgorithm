import java.io.*;
import java.util.*;

public class Solution {
	static int maxVal;
	static int K;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_1244/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[1000000][11];
            maxVal = 0;

            dfs(num.toCharArray(), 0);

            System.out.println("#" + tc + " " + maxVal);
        }
		
	}

	private static void dfs(char[] arr, int cnt) {
		if (cnt == K) {
			int val = Integer.parseInt(new String(arr));
			maxVal = Math.max(maxVal, val);
			return;
		}

		int nowVal = Integer.parseInt(new String(arr));
		if (visited[nowVal][cnt])
			return;

		visited[nowVal][cnt] = true;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				dfs(arr, cnt + 1);

				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
