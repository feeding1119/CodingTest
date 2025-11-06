

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] r = new int[n+1];
        int[] c = new int[n+1];

        StringTokenizer st;

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];

        for(int len = 1;len<n;len++){
            for(int i=1;i+len<=n;i++){
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + r[i] * c[k] * c[j];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
