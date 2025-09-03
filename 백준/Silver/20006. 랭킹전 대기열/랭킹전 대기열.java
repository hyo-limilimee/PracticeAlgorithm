import java.io.*;
import java.util.*;

public class Main {
    static int p, m;

    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int standard;
        List<Player> players = new ArrayList<>();

        Room(int standard, Player first) {
            this.standard = standard;
            this.players.add(first);
        }

        boolean canJoin(Player pl, int cap) {
            return players.size() < cap && Math.abs(pl.level - standard) <= 10;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player cur = new Player(level, name);

            boolean joined = false;
            for (Room r : rooms) {
                if (r.canJoin(cur, m)) {
                    r.players.add(cur);
                    joined = true;
                    break;
                }
            }
            if (!joined) {
                rooms.add(new Room(level, cur));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room r : rooms) {
            if (r.players.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            r.players.sort(Comparator.comparing(pl -> pl.name));
            for (Player pl : r.players) {
                sb.append(pl.level).append(' ').append(pl.name).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
