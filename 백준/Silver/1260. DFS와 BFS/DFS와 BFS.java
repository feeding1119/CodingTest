import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int N;
    static int M;
    static int K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(K);
        System.out.println();

        Arrays.fill(visited,false);
        bfs(K);
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start+" ");
        for(int i=1;i<=N;i++){
            if(graph[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        visited[start] = true;
        q.add(start);
        System.out.print(start+" ");

        while(!q.isEmpty()){
            int n = q.poll();

            for(int i=0;i<=N;i++){
                if(graph[n][i] == 1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}
