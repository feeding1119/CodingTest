

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][3];
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            house[i][0]= Integer.parseInt(st.nextToken());
            house[i][1]= Integer.parseInt(st.nextToken());
            house[i][2]= Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[N+1][3];


        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                    if(j==k) continue;

                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k] + house[i-1][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            if(dp[N][i] < answer) answer = dp[N][i];
        }
        System.out.println(answer);
    }

}
