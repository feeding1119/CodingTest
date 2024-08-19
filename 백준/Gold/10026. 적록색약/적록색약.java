import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[][] v;
    static int answer = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        char[][] blindMap = new char[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                char temp = input.charAt(j);
                map[i][j] = input.charAt(j);

                if(temp == 'G') blindMap[i][j] = 'R';
                else blindMap[i][j] = temp;
            }
        }

        v = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j]){
                    answer++;
                    dfs(i,j,map[i][j],map);
                }
            }
        }

        System.out.print(answer+" ");

        answer =0;
        v = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j]){
                    answer++;
                    dfs(i,j,blindMap[i][j],blindMap);
                }
            }
        }

        System.out.print(answer);

    }

    public static void dfs(int x,int y,char color, char[][] map){
        v[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx < N && ny >= 0 && ny < N && !v[nx][ny] && color == map[nx][ny]) dfs(nx,ny,color,map);
        }
    }
}
