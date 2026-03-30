

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node>{
        int idx,cost;

        public Node(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start,end));
    }

    public static int dijkstra(int start,int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[N+1];
        int[] cost = new int[N+1];

        for(int i=0;i<N+1;i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(v[now.idx]) continue;
            v[now.idx] = true;

            for(Node next : graph.get(now.idx)){
                if(next.cost + cost[now.idx] < cost[next.idx]){
                    cost[next.idx] = next.cost + cost[now.idx];
                    pq.offer(new Node(next.idx,cost[next.idx]));
                }
            }
        }

        return cost[end];

    }
}
