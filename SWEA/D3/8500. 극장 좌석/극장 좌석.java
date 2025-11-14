import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_8500/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			long cnt = arr[0] + 1;
			
			for (int i = 1; i < N; i++) {
				int seat = arr[i] + 1;
				cnt += seat;

			}
			cnt += arr[N - 1];
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
