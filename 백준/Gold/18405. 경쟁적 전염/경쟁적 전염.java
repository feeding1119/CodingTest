
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,K,S,X,Y;
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        List<int[]> vList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int virus = Integer.parseInt(st.nextToken());
                map[i][j] = virus;
                if(virus != 0) vList.add(new int[]{i,j,virus,0});
            }
        }

        Collections.sort(vList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for(int[] v : vList){
            q.offer(v);
        }


        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;

        bfs();

        System.out.println(map[X][Y]);

    }

    public static void bfs(){

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0;i<4;i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx >=0 && ny>=0 && nx<N && ny<N && map[nx][ny] == 0 && temp[3] < S){
                    map[nx][ny] = temp[2];
                    q.add(new int[]{nx,ny,temp[2],temp[3]+1});
                }
            }
        }

    }
}
