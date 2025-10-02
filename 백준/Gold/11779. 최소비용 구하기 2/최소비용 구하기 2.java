

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static ArrayList<ArrayList<Node>> graph;
    static int[] updateIdx;

    public static class Node implements Comparable<Node>{
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

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        updateIdx = new int[n+1];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = dijkstra(start,end);

        System.out.println(answer);

        ArrayList<Integer> routes = new ArrayList<>();

        int route = end;
        routes.add(route);

        while(route != start){
            route = updateIdx[route];
            routes.add(route);
        }
        
        System.out.println(routes.size());

        for(int i=routes.size()-1;i>=0;i--){
            System.out.print(routes.get(i)+" ");
        }

    }

    public static int dijkstra(int start,int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] v = new boolean[n+1];
        int[] cost = new int[n+1];

        for(int i=1;i<=n;i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(v[now.idx]) continue;

            v[now.idx] = true;

            for(Node next : graph.get(now.idx)){
                if(cost[next.idx] > cost[now.idx] + next.cost){
                    updateIdx[next.idx] = now.idx;
                    cost[next.idx] = cost[now.idx] + next.cost;
                    pq.offer(new Node(next.idx,cost[next.idx]));
                }
            }
        }

        return cost[end];


    }
}
