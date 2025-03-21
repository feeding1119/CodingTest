

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,e;
    static int ans = 0;
    static List<Node>[] adjList;
    static int INF = 200000000;
    static int[] cost;
    static boolean[] v;

    static class Node implements Comparable<Node>{
        int dest,cost;
        public Node(int dest,int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        v = new boolean[n+1];
        cost = new int[n+1];

        for(int i=0;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b,c));
            adjList[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += dijkstra(1,v1);
        ans1 += dijkstra(v1,v2);
        ans1 += dijkstra(v2,n);

        int ans2 = 0;
        ans2 += dijkstra(1,v2);
        ans2 += dijkstra(v2,v1);
        ans2 += dijkstra(v1,n);

        if(ans1 >= INF && ans2 >= INF) ans = -1;
        else ans = Math.min(ans1, ans2);

        System.out.println(ans);
    }

    public static int dijkstra(int start,int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(v,false);
        Arrays.fill(cost,INF);

        cost[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(v[now.dest]) continue;
            v[now.dest] = true;

            for(Node next : adjList[now.dest]){
                if(cost[next.dest] > next.cost+now.cost){
                    cost[next.dest] = next.cost+now.cost;
                    pq.add(new Node(next.dest,cost[next.dest]));
                }
            }
        }

        return cost[end];
    }
}
