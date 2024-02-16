import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static class Hero{
        private int x;
        private int y;
        private int move;
        public Hero(int x,int y,int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    static int N,M,T;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Hero> q = new LinkedList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] swordXY = new int[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 2){
                    swordXY[0] = i;
                    swordXY[1] = j;
                }
            }
        }

        int noSword = bfs(0,0,N-1,M-1);
        int sword = bfs(0,0,swordXY[0],swordXY[1]);

        if(sword != Integer.MAX_VALUE){
            sword += (N-1-swordXY[0]) + (M-1-swordXY[1]);
        }

        int result = Math.min(noSword,sword);
        if(result <= T){
            System.out.println(result);
        }else{
            System.out.println("Fail");
        }
    }

    static int bfs(int x,int y,int endX,int endY){
        visited = new boolean[N][M];

        visited[x][y] = true;
        q.offer(new Hero(x,y,0));

        while(!q.isEmpty()){
            Hero hero = q.poll();

            for(int i=0;i<4;i++){
                int nx = hero.x + dx[i];
                int ny = hero.y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] != 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Hero(nx,ny,hero.move+1));
                }

                if(nx == endX && ny == endY){
                    return hero.move+1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
