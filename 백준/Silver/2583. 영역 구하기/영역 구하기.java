import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static boolean[][] map;
    static boolean[][] v;
    static List<Integer> result = new ArrayList<>();
    static int answer;
    static int M,N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        v = new boolean[M][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<x2;j++){
                for(int k=y1;k<y2;k++){
                    map[k][j] = true;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j] && !map[i][j]){
                    answer = 0;
                    dfs(i,j);
                    result.add(answer);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for(int r : result) System.out.print(r+" ");
    }

    public static void dfs(int x, int y) {
        answer++;
        v[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx< M && ny>=0 && ny< N && !v[nx][ny] && !map[nx][ny]) dfs(nx,ny);
        }
    }
}
