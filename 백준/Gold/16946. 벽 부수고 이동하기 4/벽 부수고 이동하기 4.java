import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            String temp = br.readLine();

            for(int j=0;j<m;j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int num = 2;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 0){
                    makeRegion(i,j,num);
                    num++;
                }
            }
        }

        int[] mapCount = new int[num];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mapCount[map[i][j]]++;
            }
        }

        boolean[] v = new boolean[num];

        int[][] answer = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 1){
                    answer[i][j] = 1;
                    v = new boolean[num];
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1&&!v[map[nx][ny]]){
                            v[map[nx][ny]] = true;
                            answer[i][j] += mapCount[map[nx][ny]];
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(answer[i][j]%10);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void makeRegion(int x,int y,int num){

        Queue<int[]> q = new LinkedList<>();

        map[x][y] = num;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=0;i<4;i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] ==0){
                    map[nx][ny] = num;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

    }
}
