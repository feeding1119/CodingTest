

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,1,0};
    static int[] dy = {0,1,1};
    static int answer = 0;
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,0,0);

        System.out.println(answer);
    }

    public static void dfs(int x,int y,int d){
        if(x == n-1 && y == n-1){
            answer++;
            return;
        }

        for(int i=0;i<3;i++){
            if(d==0 && i==2) continue;
            if(d==2 && i==0) continue;

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && ny >=0 && nx < n && ny < n && map[nx][ny] == 0){
                if(i==1 && (map[nx-1][ny]==1 || map[nx][ny-1] == 1)) continue;
                dfs(nx,ny,i);
            }
        }
    }
}
