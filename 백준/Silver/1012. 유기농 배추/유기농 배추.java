

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static int answer,M,N,K;
    static boolean[][] v;
    static boolean[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        result = new int[T];
        StringTokenizer st;

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            v = new boolean[M][N];

            answer = 0;
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = true;
            }

            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    if(!v[j][k] && map[j][k]){
                        answer++;
                        dfs(j,k);
                    }
                }
            }

            result[i] = answer;
        }

        for(int r : result){
            System.out.println(r);
        }
    }

    public static void dfs(int x,int y){
        v[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<M && ny>= 0 && ny<N && !v[nx][ny] && map[nx][ny]) dfs(nx,ny);
        }
    }
}
