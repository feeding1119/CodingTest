
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,m,x;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] time;

    public static class Edge implements Comparable<Edge>{
        int idx, cost;

        public Edge(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        time = new int[n+1];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
        }

        for(int i=1;i<n+1;i++){
            dijkstra(i);
        }

        int answer = 0;
        for(int i=1;i<n+1;i++){
            if(answer < time[i]) answer = time[i];
        }

        System.out.println(answer);
    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];
        boolean[] v = new boolean[n+1];

        for(int i=1;i<n+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        pq.offer(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(v[now.idx]) continue;

            v[now.idx] = true;

            for(Edge next : graph.get(now.idx)){
                if(dist[next.idx] > dist[now.idx] + next.cost){
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.offer(new Edge(next.idx,dist[next.idx]));
                }
            }
        }

        time[start] += dist[x];

        if(start == x){
            for(int i=1;i<n+1;i++){
                time[i] += dist[i];
            }
        }

    }
}
