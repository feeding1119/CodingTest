
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        if(v[N-1][N-1]){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }

    static void dfs(int x,int y){
        v[x][y] = true;

        if(x==N-1 && y==N-1) return;

        for(int i=0;i<2;i++){
            int nx = x+map[x][y]*dx[i];
            int ny = y+map[x][y]*dy[i];

            if(nx>=0&&nx<N&&ny>=0&&ny<N&&!v[nx][ny]) dfs(nx,ny);
        }

    }
}
