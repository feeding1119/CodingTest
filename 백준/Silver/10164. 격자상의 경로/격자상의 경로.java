

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M];
        int[][] map = new int[N][M];

        int count = 1;
        int x = 0;
        int y = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(count == K){
                    x = i;
                    y = j;
                }
                else map[i][j] = count;

                count++;
            }
        }

        dp[0][0] = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i == 0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }

                if(i-1 >= 0) dp[i][j] += dp[i-1][j];
                if(j-1 >= 0) dp[i][j] += dp[i][j-1];
            }
        }

        if(K==0){
            System.out.println(dp[N-1][M-1]);
        }else{
            int temp = dp[x][y];
            N -= x;
            M -= y;
            dp = new int[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(i == 0 && j==0){
                        dp[i][j] = 1;
                        continue;
                    }

                    if(i-1 >= 0) dp[i][j] += dp[i-1][j];
                    if(j-1 >= 0) dp[i][j] += dp[i][j-1];
                }
            }

            System.out.println(temp * dp[N-1][M-1]);
        }


//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
