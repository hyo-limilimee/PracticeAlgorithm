import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_1204/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] score = new int[101];

			for (int i = 0; i < 1000; i++) {
				score[Integer.parseInt(st.nextToken())]++;
			}

			int modeScore = 0;
			int modeCnt = 0;

			for (int i = 0; i <= 100; i++) {
				if (score[i] >= modeCnt) {
					modeCnt = score[i];
					modeScore = i;
				}
			}

			sb.append("#" + test_case + " " + modeScore + "\n");
		}
		System.out.println(sb);
	}
}
