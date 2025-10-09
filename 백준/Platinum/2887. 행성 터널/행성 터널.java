import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static long answer = 0;
    static int N;

    static int[] parent;
    static ArrayList<Edge> edges;

    static class Edge implements Comparable<Edge>{
        int u,v,c;

        public Edge(int u,int v,int c){
            this.u = u;
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o){
            return this.c-o.c;
        }
    }

    static class Planet{
        int x,y,z,num;

        public Planet(int x,int y,int z,int num){
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        edges = new ArrayList<>();

        for(int i=1;i<N+1;i++){
            parent[i] = i;
        }

        Planet[] locations = new Planet[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());

            locations[i] = new Planet(x,y,z,i+1);
        }

        Arrays.sort(locations,(o1,o2)->{return o1.x-o2.x;});

        for(int i=1;i<N;i++){
            edges.add(new Edge(locations[i-1].num,locations[i].num,Math.abs(locations[i-1].x-locations[i].x)));
        }

        Arrays.sort(locations,(o1,o2)->{return o1.y-o2.y;});

        for(int i=1;i<N;i++){
            edges.add(new Edge(locations[i-1].num,locations[i].num,Math.abs(locations[i-1].y-locations[i].y)));
        }

        Arrays.sort(locations,(o1,o2)->{return o1.z-o2.z;});

        for(int i=1;i<N;i++){
            edges.add(new Edge(locations[i-1].num,locations[i].num,Math.abs(locations[i-1].z-locations[i].z)));
        }

        Collections.sort(edges);

        int count = 0;

        for(Edge e : edges){
            if(find(e.u) == find(e.v)) continue;
            count++;
            answer += e.c;
            union(e.u,e.v);

            if(count == N-1) break;
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

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }
}
