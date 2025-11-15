import java.util.*;
import java.io.*;

public class Solution {
	static int len;
	static String origin;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_1289/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			origin = br.readLine();
			len = origin.length();
			char prev = '0';

			int cnt = 0;
			for (int i = 0; i < len; i++) {
				if (origin.charAt(i) != prev) {
					cnt++;
					if (prev == '0')
						prev = '1';
					else
						prev = '0';
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
