

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] stones = new long[N+1];
        long[] dp = new long[N+1];

        for(int i=1;i<=N;i++){
            stones[i] = Long.parseLong(st.nextToken());
        }


        for(int j=2;j<=N;j++){
            long minValue = Long.MAX_VALUE;

            for(int i=1;i<j;i++){
                long temp = (j-i)*(1+Math.abs(stones[i]-stones[j]));
                if(minValue > Math.max(dp[i],temp)) {
                    minValue = Math.max(dp[i],temp);
                }
            }

            dp[j] = minValue;
        }

        System.out.println(dp[N]);

    }
}
