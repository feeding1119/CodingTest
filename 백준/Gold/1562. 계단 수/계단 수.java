

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][][] dp = new long[101][10][1<<10];

        for(int i=1;i<10;i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i=2;i<101;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<(1<<10);k++){

                    int bit = k | (1<<j);
                    if(j==0){
                        dp[i][j][bit] += dp[i-1][1][k];
                    }else if(j==9){
                        dp[i][j][bit] += dp[i-1][8][k];
                    }else{
                        dp[i][j][bit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k])%MOD;
                    }
                }

            }
        }

        long answer = 0;

        for(int i=0;i<10;i++){
            answer += dp[n][i][1023];
            answer %= MOD;
        }


        System.out.println(answer);

    }

}
