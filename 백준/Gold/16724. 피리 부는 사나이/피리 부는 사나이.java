
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] v;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new int[n][m];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                char temp = input.charAt(j);

                if(temp == 'U') map[i][j] = 0;
                if(temp == 'D') map[i][j] = 1;
                if(temp == 'L') map[i][j] = 2;
                if(temp == 'R') map[i][j] = 3;

            }
        }

        int idx = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(v[i][j] == 0){
                    dfs(i,j,idx);
                    idx++;
                }
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int x,int y,int idx){
        v[x][y] = idx;

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if(v[nx][ny] == 0) dfs(nx,ny,idx);
        else if(v[nx][ny] == idx){
            answer++;
        }
    }
}
