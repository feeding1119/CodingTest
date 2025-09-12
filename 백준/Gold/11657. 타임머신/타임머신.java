import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static final int INF = Integer.MAX_VALUE;


    static class Edge{
        int from,to,cost;

        public Edge(int from,int to,int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A,B,C));
        }

        long[] cost = new long[N+1];

        for(int i=0;i<=N;i++){
            cost[i] = INF;
        }

        int start = 1;

        cost[start] = 0;

        for(int i=1;i<N;i++){
            for(Edge e : edges){
                if(cost[e.from] != INF && cost[e.to] > cost[e.from] + e.cost){
                    cost[e.to] = cost[e.from] + e.cost;
                }
            }
        }

        boolean hasCycle = false;
        for(Edge e : edges){
            if(cost[e.from] != INF && cost[e.to] > cost[e.from] + e.cost){
                hasCycle = true;
                break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(hasCycle) bw.write("-1");
        else{
            for(int i=2;i<=N;i++){
                if(cost[i] == INF) bw.write("-1\n");
                else bw.write(cost[i]+"\n");
            }
        }
        bw.flush();

    }
}
