
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] parent;
    static Edge[] edges;
    static int answer = 0;

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

        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }

        edges = new Edge[m];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u,v,c);
        }

        Arrays.sort(edges);

        int maxCost = 0;

        for(int i=0;i<m;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            answer += now.c;
            if(maxCost < now.c) maxCost = now.c;
            union(now.u,now.v);
        }

        System.out.println(answer - maxCost);


    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
