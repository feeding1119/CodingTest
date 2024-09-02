
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 'L') {
                    v = new boolean[N][M];
                    bfs(i,j);
                }
            }
        }

        System.out.println(answer);


    }

    private static void bfs(int x,int y){

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x,y,0});
        v[x][y] = true;

        int count = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(count < temp[2]) count = temp[2];

            for(int i=0;i<4;i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !v[nx][ny] && map[nx][ny] == 'L'){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,temp[2]+1});
                }
            }
        }


        if(count > answer) answer = count;
    }
}
