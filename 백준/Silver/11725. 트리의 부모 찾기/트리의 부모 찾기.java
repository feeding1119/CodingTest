import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++){
            nodes.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes.get(A).add(B);
            nodes.get(B).add(A);
        }

        dfs(1);

        for(int i=2; i<=N;i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node){
        visited[node] = true;

        for(int n : nodes.get(node)){
            if(!visited[n]){
                parent[n] = node;
                dfs(n);
            }
        }
    }
}
