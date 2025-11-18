import java.io.*;
import java.util.*;

public class Solution {
	static int[][] arr;
	static int n;
	private static final int INF = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/swea_practice_1249/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}

			System.out.println("#" + tc + " " + dijkstra());
		}
	}

	private static int dijkstra() {
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], INF);
		}

		dist[0][0] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] { 0, 0, 0 });

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int cost = curr[2];

			if (dist[x][y] < cost)
				continue;

			if (x == n - 1 && y == n - 1)
				continue;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				int nextCost = cost + arr[x][y];

				if (nextCost < dist[nx][ny]) {
					dist[nx][ny] = nextCost;
					pq.add(new int[] { nx, ny, nextCost });
				}
			}
		}

		return dist[n - 1][n - 1];
	}
}