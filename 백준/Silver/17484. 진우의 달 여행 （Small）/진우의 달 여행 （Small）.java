
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] space = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for(int j=0;j<m;j++){
            for(int k=0;k<3;k++){
                dp[0][j][k] = space[0][j];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){

                if(j+1 < m){
                    dp[i][j][0] = Math.min(dp[i][j][0],Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+space[i][j]);
                }

                dp[i][j][1] = Math.min(dp[i][j][1],Math.min(dp[i-1][j][0],dp[i-1][j][2])+space[i][j]);

                if(j-1 >= 0){
                    dp[i][j][2] = Math.min(dp[i][j][2],Math.min(dp[i-1][j-1][0],dp[i-1][j-1][1])+space[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            for(int k=0;k<3;k++){
                answer = Math.min(answer,dp[n-1][j][k]);
            }
        }

        System.out.println(answer);

    }
}
