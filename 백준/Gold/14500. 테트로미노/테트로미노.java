import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int answer = 0;
    static int[][] map;
    static boolean[][] v;

    static int[] dx = {1,0,0};
    static int[] dy = {0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                v[i][j] = true;
                dfs(i,j,1,map[i][j]);
                v[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x,int y,int count,int total){


        if(count == 4){
            if(total > answer) answer = total;
            return;
        }

        if(count == 2){
            for(int i=0;i<3;i++){
                for(int j=i+1;j<3;j++){
                    int ox = x + dx[i];
                    int oy = y + dy[i];

                    int tx = x + dx[j];
                    int ty = y + dy[j];

                    if(ox >=0 && ox<n && oy >=0 && oy < m && !v[ox][oy]){
                        if(tx >=0 && tx<n && ty >=0 && ty < m && !v[tx][ty]){
                            if(total+map[ox][oy]+map[tx][ty] > answer) answer = total+map[ox][oy]+map[tx][ty];
                        }
                    }
                }
            }
        }

        for(int i=0;i<3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx<n && ny >=0 && ny < m && !v[nx][ny]){
                v[nx][ny] = true;
                dfs(nx,ny,count+1,total+map[nx][ny]);
                v[nx][ny] = false;
            }
        }


    }
}
