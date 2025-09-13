

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map,cMap;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cMap = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                cMap[i][j] = temp;
            }
        }

        dfs(0,0);

        System.out.println(answer);
    }

    public static void dfs(int start,int count){
        if(count == 3){
            calcVirus();
            return;
        }

        for(int i=start;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(i,count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void calcVirus(){
        int[][] cMap = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                cMap[i][j] = map[i][j];
                if(map[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] virus = q.poll();

            for(int i=0;i<4;i++){
                int nx = virus[0] + dx[i];
                int ny = virus[1] + dy[i];

                if(nx>=0 && ny >=0 && nx < N && ny < M && cMap[nx][ny] == 0){
                    cMap[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        calcSafetyZone(cMap);

    }

    public static void calcSafetyZone(int[][] cMap){
        int result = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(cMap[i][j] == 0) result++;
            }
        }

//        if(answer < result){
//            for(int i=0;i<N;i++){
//                for(int j=0;j<M;j++){
//                    System.out.print(cMap[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        if(answer < result) answer = result;

    }
}
