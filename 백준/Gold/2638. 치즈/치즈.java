
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while(true){
            outDoorAir(map);

            if(checkCheeze(map)) break;

            map = runCheeze(map);
            time++;
        }

        System.out.println(time);
    }

    public static void outDoorAir(int[][] map){
        boolean[][] v = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        map[0][0] = 2;
        v[0][0] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0;i<4;i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny] && map[nx][ny] != 1){
                    v[nx][ny] = true;
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }
            }

        }


    }

    public static boolean checkCheeze(int[][] map){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 1) return false;
            }
        }

        return true;
    }

    public static int[][] runCheeze(int[][] map){
        int[][] result = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] != 1) continue;


                int count = 0;

                for(int k=0;k<4;k++){
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if(map[nx][ny] == 2) count++;
                }

                if(count < 2) result[i][j] = 1;
            }
        }

        return result;
    }
}
