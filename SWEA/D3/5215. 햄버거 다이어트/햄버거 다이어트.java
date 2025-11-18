import java.util.*;
import java.io.*;

public class Solution {
	static int N, L;
	static int maxScore;
	static int[] scores;
	static int[] calories;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/swea_practice_5215/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			scores = new int[N];
			calories = new int[N];
			maxScore = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
			    st = new StringTokenizer(br.readLine());
			    scores[i] = Integer.parseInt(st.nextToken());
			    calories[i] = Integer.parseInt(st.nextToken());
			}
	
			dfs(0, 0, 0);

			System.out.println("#" + tc + " " + maxScore);
		}
	}

	private static void dfs(int idx, int scoreSum, int calSum) {
		if (calSum > L)
			return;

		if (idx == N) {
			maxScore = Math.max(scoreSum, maxScore);
			return;
		}

		dfs(idx + 1, scores[idx] + scoreSum, calories[idx] + calSum);
		dfs(idx + 1, scoreSum, calSum);
	}
}
