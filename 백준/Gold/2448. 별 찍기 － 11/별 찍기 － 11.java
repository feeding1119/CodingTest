import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][2*n];

        for(int i=0;i<n;i++){
            for(int j=0;j<2*n;j++){
                map[i][j] = ' ';
            }
        }

        dfs(0,n,n);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=1;j<2*n;j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int x,int y,int n){
        if(n==3){
            map[x][y] = '*';
            map[x+1][y+1] = '*';
            map[x+1][y-1] = '*';
            map[x+2][y+2] = '*';
            map[x+2][y-2] = '*';
            map[x+2][y+1] = '*';
            map[x+2][y] = '*';
            map[x+2][y-1] = '*';
            return;
        }

        n /= 2;

        dfs(x,y,n);

        dfs(x+n,y-n,n);

        dfs(x+n,y+n,n);
    }
}
