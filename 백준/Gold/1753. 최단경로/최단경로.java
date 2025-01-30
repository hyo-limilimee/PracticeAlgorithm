import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] graph;
    static final int INF = 1000000000;
    static int[] dist;
    static int V, E, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        // 거리 배열 초기화
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        // 우선순위 큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()){
            Edge current = pq.poll();
            int curVertex = current.vertex;
            int curDist = current.weight;

            // 이미 방문한 정점은 무시
            if(curDist > dist[curVertex]) continue;

            // 현재 정점과 연결된 모든 간선 처리
            for (Edge neighbor : graph[curVertex]) {
                int nextVertex = neighbor.vertex;
                int weight = neighbor.weight;

                // 새로운 경로가 더 짧으면 갱신
                if (dist[nextVertex] > dist[curVertex] + weight) {
                    dist[nextVertex] = dist[curVertex] + weight;
                    pq.add(new Edge(nextVertex, dist[nextVertex]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
