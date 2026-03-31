import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n;
    static int maxValue = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if(temp > maxValue) maxValue = temp;
            }
        }

        for(int i=1;i<maxValue;i++){
            boolean[][] v = new boolean[n][n];

            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(map[j][k] <= i) v[j][k] = true;
                }
            }

            int count = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(!v[j][k]) {
                        count++;
                        bfs(v,j,k);
                    }
                }
            }
            if(count > answer ) answer = count;
        }

        System.out.println(answer);

    }

    public static void bfs(boolean[][] v,int x,int y){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x,y});
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0;i<4;i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx>=0 && ny >=0 && nx <n && ny <n && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
