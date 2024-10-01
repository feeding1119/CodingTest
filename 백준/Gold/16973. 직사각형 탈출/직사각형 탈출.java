

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,H,W,Sx,Sy,Fx,Fy;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken())-1;
        W = Integer.parseInt(st.nextToken())-1;
        Sx = Integer.parseInt(st.nextToken())-1;
        Sy = Integer.parseInt(st.nextToken())-1;
        Fx = Integer.parseInt(st.nextToken())-1;
        Fy = Integer.parseInt(st.nextToken())-1;

        bfs();

    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{Sx,Sy,0});
        v[Sx][Sy] = true;
        while(!q.isEmpty()){
            int[] pos = q.poll();

            //System.out.println(pos[0]+" "+pos[1]);
            if(isFinish(pos[0],pos[1])){
                System.out.println(pos[2]);
                return;
            }
            for(int i=0;i<4;i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx+H >= N || ny+W >= M) continue;

                if(nx>=0 && ny>=0 && canMove(nx,ny) && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,pos[2]+1});
                }
            }
        }

        System.out.println(-1);

    }

    private static boolean canMove(int x,int y){
        for(int i=x;i<=x+H;i++){
            if(map[i][y] == 1 || map[i][y+W] == 1) return false;
        }

        for(int j=y;j<=y+W;j++){
            if(map[x][j] == 1 || map[x+H][j] == 1) return false;
        }

        return true;
    }

    private static boolean isFinish(int x,int y){
        if(x == Fx && y == Fy) return true;

        return false;
    }
}
