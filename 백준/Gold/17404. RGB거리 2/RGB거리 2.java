import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;

        int[][] rgb = new int[n][3];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgb[i][0] = r;
            rgb[i][1] = g;
            rgb[i][2] = b;
        }

        for(int k=0;k<3;k++){
            int[][] dp = new int[n][3];
            for(int i=0;i<3;i++){
                if(i==k) dp[0][i] = rgb[0][i];
                else dp[0][i] = 1000001;
            }

            for(int i=1;i<n;i++){
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + rgb[i][2];
            }

            for(int i=0;i<3;i++){
                if(i!=k){
                    answer = Math.min(answer,dp[n-1][i]);
                }
            }
        }

        System.out.println(answer);

    }

}
