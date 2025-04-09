import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int N, M, fuel;
    static int[][] map;
    static int taxiX, taxiY;
    static int[] dx = {-1, 0, 1, 0}; // 상 좌 하 우
    static int[] dy = {0, -1, 0, 1};
    static List<Passenger> passengers = new ArrayList<>();

    static class Passenger {
        int departureX, departureY;
        int arrivalX, arrivalY;

        Passenger(int departureX, int departureY, int arrivalX, int arrivalY) {
            this.departureX = departureX;
            this.departureY = departureY;
            this.arrivalX = arrivalX;
            this.arrivalY = arrivalY;
        }
    }

    static class PassengerDist {
        Passenger passenger;
        int dist;

        PassengerDist(Passenger passenger, int dist) {
            this.passenger = passenger;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken());
        taxiY = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            passengers.add(new Passenger(a, b, c, d));
        }

        while (!passengers.isEmpty()) {
            Passenger passenger = getPassenger();
            if (passenger == null) {
                fuel = -1;
                break;
            }

            int dist = drive(passenger);
            if (dist == -1 || fuel < dist) {
                fuel = -1;
                break;
            }

            fuel -= dist;
            fuel += dist * 2;

            taxiX = passenger.arrivalX;
            taxiY = passenger.arrivalY;

            passengers.remove(passenger);
        }

        System.out.println(fuel);
    }

    private static Passenger getPassenger() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new LinkedList<>();
        List<PassengerDist> candidates = new ArrayList<>();

        queue.offer(new int[]{taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (Passenger p : passengers) {
                if (p.departureX == x && p.departureY == y) {
                    candidates.add(new PassengerDist(p, dist));
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        if (candidates.isEmpty()) return null;

        // 거리 → 행 → 열 순 정렬
        candidates.sort((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.passenger.departureX != b.passenger.departureX)
                return a.passenger.departureX - b.passenger.departureX;
            return a.passenger.departureY - b.passenger.departureY;
        });

        PassengerDist chosen = candidates.get(0);
        if (fuel < chosen.dist) return null;

        fuel -= chosen.dist;
        taxiX = chosen.passenger.departureX;
        taxiY = chosen.passenger.departureY;

        return chosen.passenger;
    }

    private static int drive(Passenger passenger) {
        return bfs(passenger.departureX, passenger.departureY, passenger.arrivalX, passenger.arrivalY);
    }

    private static int bfs(int sX, int sY, int eX, int eY) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sX, sY, 0});
        visited[sX][sY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == eX && y == eY) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1; // 도달 불가능
    }
}
