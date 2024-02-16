import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,x,y;
    static boolean[][] relation;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        relation = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = true;
            relation[b][a] = true;
        }

        dfs(x,0);
        
        System.out.println(-1);

    }

    static void dfs(int now, int count){
        if(now==y){
            System.out.println(count);
            System.exit(0);
        }

        visited[now] = true;

        for(int i=1;i<=n;i++){
            if(relation[now][i] && !visited[i]){
                dfs(i,count+1);
            }
        }
    }
}
