

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K,W,H;
    static int[][] map;
    static boolean[][][] v;
    static int[] hx = {-2,-1, 1, 2,2,1,-1,-2};
    static int[] hy = {1,2,2,1,-1,-2,-2,-1};

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W][H];
        v = new boolean[W][H][K+1];

        for(int i=0;i<W;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<H;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(answer);

    }

    static private void bfs(){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0,0,0});
        v[0][0][0] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            int x = temp[0];
            int y = temp[1];
            int usedH = temp[2];
            int count = temp[3];

            if(x == W-1 && y == H-1){
                answer = count;
                return;
            }

            if(usedH < K){
                for(int i=0;i<8;i++){
                    int nx = x+hx[i];
                    int ny = y+hy[i];

                    if(nx>=0 && ny>=0 && nx<W && ny<H && !v[nx][ny][usedH+1] && map[nx][ny] != 1){

                        v[nx][ny][usedH+1] = true;
                        q.offer(new int[]{nx,ny,usedH+1,count+1});
                    }
                }
            }

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<W && ny<H && !v[nx][ny][usedH] && map[nx][ny] != 1){
                    v[nx][ny][usedH] = true;
                    q.offer(new int[]{nx,ny,usedH,count+1});
                }
            }
        }

        answer = -1;
    }
}
