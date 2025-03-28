

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] adjList;
    static boolean[] v;
    static int[] cost;

    static int INF = 100000000;
    static int n, d, c;

    static class Node implements Comparable<Node> {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[n + 1];
            cost = new int[n + 1];
            v = new boolean[n + 1];

            for (int i = 0; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adjList[b].add(new Node(a, s));


            }

            dijkstra(c);

            int infection = 0;
            int total = 0;
            for (int i = 1; i < n + 1; i++) {
                if (cost[i] != INF) {
                    infection++;
                    total = Math.max(total, cost[i]);
                }
            }

            System.out.println(infection + " " + total);
        }
    }

    static public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(cost, INF);
        Arrays.fill(v, false);

        cost[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (v[now.dest]) continue;
            v[now.dest] = true;

            for (Node next : adjList[now.dest]) {
                if (cost[next.dest] > next.cost + now.cost) {
                    cost[next.dest] = next.cost + now.cost;
                    pq.add(new Node(next.dest, cost[next.dest]));
                }

            }
        }
    }
}
