import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/swea_practice_1979/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 퍼즐 가로
			int K = Integer.parseInt(st.nextToken()); // 단어 길이
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로
			int answer = 0;

			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1)
						cnt++;
					else {
						if (cnt == K)
							answer++;
						cnt = 0;
					}
				}
				if (cnt == K)
					answer++;
			}

			// 세로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1)
						cnt++;
					else {
						if (cnt == K)
							answer++;
						cnt = 0;
					}
				}
				if (cnt == K)
					answer++;
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

}
