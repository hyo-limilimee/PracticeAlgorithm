import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_3282/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] v = new int[N + 1];
			int[] c = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[K + 1];

			for (int i = 1; i <= N; i++) {
				for (int w = K; w >= v[i]; w--) {
					dp[w] = Math.max(dp[w], dp[w - v[i]] + c[i]);
				}
			}

			sb.append("#" + test_case + " " + dp[K] + "\n");
		}
		System.out.println(sb);
	}
}
