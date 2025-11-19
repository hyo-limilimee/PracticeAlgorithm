import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int cnt;
	static boolean[] col, diag1, diag2;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/swea_practice_2806/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			cnt = 0;
			col = new boolean[n];
			diag1 = new boolean[2 * n];
			diag2 = new boolean[2 * n];

			nQueen(0);

			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static void nQueen(int row) {
		if (row == n) {
			cnt++;
			return;
		}

		for (int c = 0; c < n; c++) {
			if (isPossible(row, c)) {
				col[c] = true;
				diag1[row + c] = true;
				diag2[row - c + n - 1] = true;

				nQueen(row + 1);

				col[c] = false;
				diag1[row + c] = false;
				diag2[row - c + n - 1] = false;
			}
		}

	}

	private static boolean isPossible(int r, int c) {
		if (col[c])
			return false;
		if (diag1[r + c])
			return false;
		if (diag2[r - c + n - 1])
			return false;
		return true;
	}
}
