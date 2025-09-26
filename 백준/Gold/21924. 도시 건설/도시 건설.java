
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] parent;
    static Edge[] edges;
    static long answer = 0;

    public static class Edge implements Comparable<Edge>{

        int u,v,c;

        public Edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o){
            return this.c - o.c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        edges = new Edge[m];

        long cost = 0;
        int count = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cost += c;

            edges[i] = new Edge(a,b,c);
        }


        Arrays.sort(edges);

        for(int i=0;i<m;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            answer += now.c;
            union(now.u,now.v);
            count++;

        }

        if(count == n-1) System.out.println(cost - answer);
        else System.out.println(-1);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = parent[x];
        y = parent[y];

        if(x > y)  parent[x] = y;
        else parent[y] = x;
    }
}
