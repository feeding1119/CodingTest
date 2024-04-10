
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M,N;
    static int[][] map;
    static boolean[][] v;

    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {-1,-1,-1,0,1,1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        v = new boolean[M][N];

        int count = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !v[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x,int y){
        v[x][y] = true;

        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<M && ny>=0 && ny<N && !v[nx][ny] && map[nx][ny]==1) dfs(nx,ny);
        }
    }
}
