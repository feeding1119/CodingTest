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

        int[][] maze = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                maze[i][j] = input.charAt(j)-'0';
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        int[] position = new int[]{0,0};
        visited[position[0]][position[1]] = true;

        queue.add(new int[]{position[0],position[1]});

        while(!queue.isEmpty()){
            position = queue.poll();

            for(int i=0;i<4;i++){
                int nx = position[0] +dx[i];
                int ny = position[1] +dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false && maze[nx][ny] != 0){
                    maze[nx][ny] = maze[position[0]][position[1]] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(maze[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(maze[N-1][M-1]);
    }
}
