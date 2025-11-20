import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/swea_practice_1209/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			int maxSum = Integer.MIN_VALUE;

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				maxSum = Math.max(maxSum, sum);
			}

			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				maxSum = Math.max(maxSum, sum);
			}

			int diagSum1 = 0;
			for (int i = 0; i < 100; i++) {
				diagSum1 += arr[i][i];
			}
			maxSum = Math.max(maxSum, diagSum1);

			int diagSum2 = 0;
			for (int i = 0; i < 100; i++) {
				diagSum2 += arr[i][99 - i];
			}

			maxSum = Math.max(maxSum, diagSum2);

			System.out.println("#" + tc + " " + maxSum);
		}
	}

}
