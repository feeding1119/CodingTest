
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m,start,end;
    static int[] money;
    static ArrayList<Edge> edges;

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

        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money = new int[n];

        edges = new ArrayList<>();

        long[] cost = new long[n];

        for(int i=0;i<n;i++){
            cost[i] = Long.MIN_VALUE;
        }



        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,c));
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        cost[start] = money[start];


        for(int i=0;i<n+100;i++){
            for(Edge e : edges){
                if(cost[e.from] == Long.MIN_VALUE) continue;

                if(cost[e.from] == Long.MAX_VALUE){
                    cost[e.to] = Long.MAX_VALUE;
                    continue;
                }
                if(cost[e.to] < cost[e.from] + money[e.to] - e.cost){
                    cost[e.to] = cost[e.from] +money[e.to] - e.cost;
                    if(i>=n){
                        cost[e.to] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(cost[end] == Long.MIN_VALUE) System.out.println("gg");
        else if(cost[end] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(cost[end]);



    }
}
