
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static boolean[] isVisited;
    static boolean[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        edges = new boolean[N+1][N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a][b] = true;
            edges[b][a] = true;
        }


        for(int i=1;i<=N;i++){
            if(!isVisited[i]){
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int n){
        isVisited[n] = true;

        for(int i=1;i<edges[0].length;i++){
            if(!isVisited[i] && edges[n][i]){
                dfs(i);
            }
        }
    }
}
