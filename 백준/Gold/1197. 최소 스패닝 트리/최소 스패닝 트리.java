
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int V,E;
    static int[] parent;
    static Edge[] edges;

    static class Edge implements Comparable<Edge>{
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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new Edge[E];

        for(int i=1;i<V+1;i++){
            parent[i] = i;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a,b,c);
        }

        Arrays.sort(edges);

        int answer = 0;

        for(int i=0;i<E;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            answer += now.c;
            union(now.u,now.v);
        }

        System.out.println(answer);




    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x,int y){
        x = parent[x];
        y = parent[y];

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }

}
