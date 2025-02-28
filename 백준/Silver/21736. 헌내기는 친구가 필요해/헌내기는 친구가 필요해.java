

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int answer = 0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        boolean[][] v = new boolean[n][m];

        int x = 0;
        int y = 0;
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                char temp = input.charAt(j);
                map[i][j] = temp;
                if(temp == 'I'){
                    x = i;
                    y = j;
                }
            }
        }

        v[x][y] = true;
        dfs(x,y,v);

        if(answer == 0) System.out.println("TT");
        else System.out.println(answer);

    }

    public static void dfs(int x,int y,boolean[][] v){
        if(map[x][y] == 'P'){
            answer +=1;
            map[x][y] = 'O';
        }

        v[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny] && map[nx][ny] !='X' ){
                dfs(nx,ny,v);
            }
        }
    }
}
