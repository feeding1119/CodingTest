
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,E;
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        boolean flag = false;

        int t1 = dijkstra(1,v1);
        int t2 = dijkstra(v1,v2);
        int t3 = dijkstra(v2,N);

        if(t1 == Integer.MAX_VALUE || t2 == Integer.MAX_VALUE || t3 == Integer.MAX_VALUE) flag = true;

        int ans1 = t1+t2+t3;

        int answer = ans1;

        t1 = dijkstra(1,v2);
        t2 = dijkstra(v2,v1);
        t3 = dijkstra(v1,N);

        if(flag && (t1 == Integer.MAX_VALUE || t2 == Integer.MAX_VALUE || t3 == Integer.MAX_VALUE)){
            System.out.println(-1);
            return;
        }

        int ans2 = t1+t2+t3;

        if(answer > ans2) answer = ans2;

        System.out.println(answer);
    }

    public static int dijkstra(int start,int end){
        boolean[] v = new boolean[N+1];
        int[] cost = new int[N+1];

        for(int i=0;i<=N;i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[start] = 0;

        for(int i=0;i<N;i++){

            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for(int j=1;j<=N;j++){
                if(!v[j] && cost[j] < nodeValue){
                    nodeValue = cost[j];
                    nodeIdx = j;
                }
            }

            v[nodeIdx] = true;

            for(int j=0;j<graph.get(nodeIdx).size();j++){

                Node adjNode = graph.get(nodeIdx).get(j);

                if(cost[adjNode.idx] > nodeValue + adjNode.cost){
                    cost[adjNode.idx] = nodeValue + adjNode.cost;
                }

            }
        }

        return cost[end];
    }
}
