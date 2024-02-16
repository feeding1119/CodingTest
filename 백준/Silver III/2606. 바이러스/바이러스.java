import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[][] virus;
    static boolean[] visited;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        virus = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            virus[a][b] = true;
            virus[b][a] = true;
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int start){
        visited[start]= true;

        for(int i=1;i<=N;i++){
            if(virus[start][i] && !visited[i]){
                count++;
                dfs(i);
            }
        }
    }
}
