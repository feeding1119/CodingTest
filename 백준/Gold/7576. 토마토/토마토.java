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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[M][N];
        boolean[][] visited = new boolean[M][N];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int temp = Integer.parseInt(st.nextToken());
                tomato[i][j] = temp;
                if(temp == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }


        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            int[] position = queue.poll();

            for(int i=0;i<4;i++){
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && visited[nx][ny] == false && tomato[nx][ny] != -1){
                    tomato[nx][ny] = tomato[position[0]][position[1]] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }

        }

        int maxValue = 0;
        boolean check = true;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(tomato[i][j] == 0){
                    check = false;
                }
                if(maxValue < tomato[i][j]){
                    maxValue = tomato[i][j];
                }
            }
        }

        if(check){
            System.out.println(maxValue-1);
        }else{
            System.out.println(-1);
        }
        

    }
}
