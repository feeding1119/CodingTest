

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n-1][21];

        dp[0][nums[0]] = 1;

        for(int i=1;i<n-1;i++){
            for(int j=0;j<21;j++){
                if(dp[i-1][j] != 0){
                    if(j+nums[i] < 21) dp[i][j+nums[i]] += dp[i-1][j];
                    if(j-nums[i] >= 0) dp[i][j-nums[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n-2][nums[n-1]]);
    }
}
