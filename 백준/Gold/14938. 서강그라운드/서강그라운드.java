
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,m,r;
    static int[] item;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static final int INF  = Integer.MAX_VALUE;

    public static class Edge implements Comparable<Edge>{
        int idx,cost;

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
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,l));
            graph.get(b).add(new Edge(a,l));
        }

        int answer = 0;

        for(int i=1;i<n+1;i++){
            int value = dijkstra(i);

            if(value > answer) answer = value;
        }

        System.out.println(answer);

    }

    public static int dijkstra(int start){
        int[] dist = new int[n+1];
        boolean[] v = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=0;i<n+1;i++){
            dist[i] = INF;
        }

        dist[start] = 0;
        pq.offer(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(v[now.idx]) continue;
            v[now.idx] = true;

            for(Edge next : graph.get(now.idx)){
                if(dist[next.idx] > now.cost + next.cost){
                    dist[next.idx] = now.cost + next.cost;
                    pq.offer(new Edge(next.idx,dist[next.idx]));
                }
            }
        }

        int result = 0;


        for(int i=1;i<n+1;i++){
            if(dist[i] <= m){
                result += item[i];
            }
        }
        return result;

    }


}
