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

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        m = (n*n-n)/2;

        edges = new Edge[m];

        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                edges[idx++] = new Edge(i,j,map[i][j]);
            }
        }

        Arrays.sort(edges);

        for(int i=0;i<m;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            answer += now.c;
            union(now.u,now.v);
        }

        System.out.println(answer);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = parent[x];
        y = parent[y];

        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
