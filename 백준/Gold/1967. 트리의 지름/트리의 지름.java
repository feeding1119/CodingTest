
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]>[] graph;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];

        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b,cost});
            graph[b].add(new int[]{a,cost});
        }

        boolean[] v = new boolean[n+1];

        for(int i=1;i<=n;i++){
            v[i] = true;
            dfs(i,0,v);
            v[i] = false;
        }

        System.out.println(answer);
        
    }

    public static void dfs(int a,int cost,boolean[] v){

        answer = Math.max(answer,cost);

        for(int i=0;i<graph[a].size();i++){
            int b = graph[a].get(i)[0];
            if(!v[b]){
                v[b] = true;
                dfs(b,cost+graph[a].get(i)[1],v);
                v[b] = false;
            }
        }
    }
}
