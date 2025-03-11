

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];
        int[][] item = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            item[i][0] = w;
            item[i][1] = v;
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];

                if(j>=item[i-1][0]) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-item[i-1][0]]+item[i-1][1]);
            }
        }

        System.out.println(dp[n][k]);
    }
}
