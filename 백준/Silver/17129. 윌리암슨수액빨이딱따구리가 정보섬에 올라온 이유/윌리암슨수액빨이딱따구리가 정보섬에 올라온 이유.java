
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] map;
    static boolean[][] v;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                int temp = input.charAt(j) - '0';
                map[i][j] = temp;

                if(temp == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;

        int chung = bfs(startX,startY,3);
        if(chung < minDistance){
            minDistance = chung;
        }
        int sushi = bfs(startX,startY,4);
        if(sushi<minDistance){
            minDistance = sushi;
        }
        int cheese = bfs(startX,startY,5);
        if(cheese<minDistance){
            minDistance = cheese;
        }

        if( minDistance == Integer.MAX_VALUE){
            System.out.println("NIE");
        }else{
            System.out.println("TAK");
            System.out.println(minDistance);
        }


    }

    static int bfs(int x,int y, int goal){
        v = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x,y,0});
        v[x][y] = true;

        while(!q.isEmpty()){
            int[] position = q.poll();

            for(int i=0;i<4;i++){
                int nx = position[0]+dx[i];
                int ny = position[1]+dy[i];

                if(nx>=0 && nx<n && ny >=0 && ny<m && !v[nx][ny] && map[nx][ny] != 1) {
                    if(map[nx][ny] == goal) return position[2]+1;
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,position[2]+1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
