import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,H;
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[M][N][H];
        visited = new boolean[M][N][H];
        boolean checkValue = false;

        for(int k=0;k<H;k++){
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    int value = Integer.parseInt(st.nextToken());
                    tomato[i][j][k] = value;
                    if(value == 0) checkValue =true;
                }
            }
        }

        if(!checkValue){
            System.out.println(0);
            System.exit(0);
        }


        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<H;k++){
                    if(tomato[i][j][k] == 1) {
                        q.add(new int[]{i,j,k});

                    }
                }
            }
        }

        bfs();

        int result = 0;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<H;k++){
                    if(tomato[i][j][k] == 0){
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if(tomato[i][j][k] > result){
                        result = tomato[i][j][k];
                    }
                }
            }
        }

        System.out.println(result-1);
    }

    static void bfs(){

        while(!q.isEmpty()){
            int[] position = q.poll();

            visited[position[0]][position[1]][position[2]] = true;

            for(int i=0;i<6;i++){
                int nx = position[0]+ dx[i];
                int ny = position[1] + dy[i];
                int nz = position[2] + dz[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && nz>=0 && nz<H && tomato[nx][ny][nz] ==0 && !visited[nx][ny][nz]){
                    tomato[nx][ny][nz] = tomato[position[0]][position[1]][position[2]]+1;

                    q.offer(new int[]{nx,ny,nz});
                }
            }
        }
    }
}
