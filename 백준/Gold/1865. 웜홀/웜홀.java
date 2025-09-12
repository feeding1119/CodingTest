
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

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

        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        final long INF = Long.MAX_VALUE;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<TC;i++){

            ArrayList<Edge> edges = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());



            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S,E,T));
                edges.add(new Edge(E,S,T));
            }

            for(int j=0;j<W;j++){
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken()) * -1;

                edges.add(new Edge(S,E,T));
            }


            long[] cost = new long[N+1];

            for(int j=1;j<N;j++){
                for(Edge edge : edges){
                    if(cost[edge.from] != INF && cost[edge.to] > cost[edge.from] + edge.cost){
                        cost[edge.to] = cost[edge.from] + edge.cost;
                    }
                }
            }

            boolean hasCycle = false;

            for(Edge edge : edges){
                if(cost[edge.from] != INF && cost[edge.to] > cost[edge.from] + edge.cost){
                    hasCycle = true;
                    break;
                }
            }
            if(hasCycle) bw.write("YES\n");
            else bw.write("NO\n");


        }

        bw.flush();
    }
}
