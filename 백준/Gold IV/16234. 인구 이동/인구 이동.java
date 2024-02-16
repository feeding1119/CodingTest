import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,L,R;
    static int[][] map;
    static int[][] prevMap;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = 0;
    static Queue<int[]> q = new LinkedList<>();
    static int qsum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        prevMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            for(boolean[] v:visited){
                Arrays.fill(v,false);
            }


            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    prevMap[i][j] = map[i][j];
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        qsum=0;
                        dfs(i,j);
                        calcQueue(qsum/q.size());
                    }
                }
            }

            if(checkPrev()){
                break;
            }else{
                answer++;
            }
        }


        System.out.println(answer);
    }

    static void dfs(int x,int y){
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        qsum += map[x][y];

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >=0 && ny < N && !visited[nx][ny]){
                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if(diff>=L && diff<=R){
                    dfs(nx,ny);
                }
            }
        }

    }

    static boolean checkPrev(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] != prevMap[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    static void calcQueue(int value){
        while(!q.isEmpty()){
            int[] position = q.poll();

            map[position[0]][position[1]] = value;
        }
    }
}
