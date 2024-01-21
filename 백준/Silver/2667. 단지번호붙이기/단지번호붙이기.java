import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 1;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == false && map[i][j] != 0){
                    dfs(i,j);
                    count++;
                }
            }
        }

        int[] mapCount = new int[count-1];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] != 0){
                    mapCount[map[i][j]-1] += 1;
                }
            }
        }

        System.out.println(count-1);

        Arrays.sort(mapCount);
        
        for(int n : mapCount){
            System.out.println(n);
        }

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        map[x][y] = count;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == false && map[nx][ny] != 0){
                visited[nx][ny] = true;
                map[nx][ny] = count;
                dfs(nx,ny);
            }
        }
    }
}
