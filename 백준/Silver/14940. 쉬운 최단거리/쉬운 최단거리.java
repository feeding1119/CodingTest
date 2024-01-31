import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num == 2){
                    q.offer(new int[]{i,j});
                    map[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] position = q.poll();

            for(int i=0;i<4;i++){
                int nx = position[0]+dx[i];
                int ny = position[1]+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 0 && visited[nx][ny] == false){
                    map[nx][ny] = map[position[0]][position[1]] + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && map[i][j] != 0){
                    System.out.print("-1 ");
                }else{
                    System.out.print(map[i][j]+" ");
                }
            }
            System.out.println();
        }



    }
}
