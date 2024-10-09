import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
                if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];
                dp[i][j] += map[i][j];

            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int sx =  Integer.parseInt(st.nextToken());
            int sy =  Integer.parseInt(st.nextToken());
            int ex =  Integer.parseInt(st.nextToken());
            int ey =  Integer.parseInt(st.nextToken());

            System.out.println(dp[ex][ey] - dp[ex][sy-1] - dp[sx-1][ey] + dp[sx-1][sy-1]);
        }
    }


}
