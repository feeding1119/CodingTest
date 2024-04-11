
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] triangle = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][n+1];

        dp[1][1] = triangle[0][0];

        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i-1][j-1];
            }
        }

        int answer =0;
        for(int i=1;i<=n;i++){
            if(answer < dp[n][i]) answer =dp[n][i];
        }

        System.out.println(answer);


    }
}
