import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j] && maps[i].charAt(j) != 'X') {

                    int sum = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];

                        sum += maps[x].charAt(y) - '0';

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (visited[nx][ny]) continue;
                            if (maps[nx].charAt(ny) == 'X') continue;

                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }

                    result.add(sum);
                }
            }
        }

        if (result.isEmpty()) return new int[]{-1};

        Collections.sort(result);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
