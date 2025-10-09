
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] parent;
    static Edge[] edges;

    static int answer = 0;

    public static class Edge {
        int u,v,c;

        public Edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M+1];

        for(int i=0;i<M+1;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u,v,c);
        }


        parent = new int[N+1];

        for(int i=1;i<N+1;i++){
            parent[i] = i;
        }

        Arrays.sort(edges,(o1,o2)->{return o1.c - o2.c;});

        int count = 0;

        for(int i=0;i<M+1;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            if(now.c == 0) count++;
            union(now.u,now.v);
        }

        answer = count*count;

        for(int i=1;i<N+1;i++){
            parent[i] = i;
        }

        Arrays.sort(edges,(o1,o2)->{return o2.c - o1.c;});

        count = 0;

        for(int i=0;i<M+1;i++){
            Edge now = edges[i];
            if(find(now.u) == find(now.v)) continue;
            if(now.c == 0) count++;
            union(now.u,now.v);
        }

        answer -= count*count;

        System.out.println(answer);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = parent[x];
        y = parent[y];

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }

}
