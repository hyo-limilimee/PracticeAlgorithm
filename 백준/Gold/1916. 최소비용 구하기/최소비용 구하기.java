import java.io.*;
import java.util.*;

class Node {
    int to;
    int cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(src);
        System.out.println(dist[dest]);
    }

    static void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.to;
            int nowCost = current.cost;

            if (nowCost > dist[now]) continue;

            for (Node next : graph.get(now)) {
                int newCost = nowCost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
