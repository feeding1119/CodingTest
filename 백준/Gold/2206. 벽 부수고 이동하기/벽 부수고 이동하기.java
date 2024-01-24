import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Mover{
        int x;
        int y;
        int count;
        boolean isDestroyed;

        public Mover(int x,int y, int count,boolean isDestroyed){
            this.x = x;
            this.y = y;
            this.count = count;
            this.isDestroyed  = isDestroyed;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<Mover> queue = new LinkedList<>();
        queue.add(new Mover(0,0,1,false));
        visited[0][0][0] = true;


        while(!queue.isEmpty()){
            Mover mover = queue.poll();

            if(mover.x==N-1 && mover.y==M-1){
                System.out.println(mover.count);
                return;
            }

            for(int i=0;i<4;i++){
                int nx = mover.x + dx[i];
                int ny = mover.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1){
                    if(!mover.isDestroyed && !visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        queue.add(new Mover(nx,ny, mover.count+1,mover.isDestroyed ));
                    }else if(mover.isDestroyed && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        queue.add(new Mover(nx,ny, mover.count+1,mover.isDestroyed ));
                    }
                }

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !mover.isDestroyed){
                    visited[nx][ny][1] = true;
                    queue.add(new Mover(nx,ny, mover.count+1,!mover.isDestroyed ));
                }

            }
        }

        System.out.println(-1);

    }
}
