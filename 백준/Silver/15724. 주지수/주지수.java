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

        int[][] person = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                person[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[][] range = new int[K][4];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                range[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];

        dp[0][0] = person[0][0];

        for(int i=1;i<N;i++){
            dp[i][0] = dp[i-1][0] + person[i][0];
        }

        for(int i=1;i<M;i++){
            dp[0][i] = dp[0][i-1] + person[0][i];
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + person[i][j];
            }
        }

//        for(int i=0; i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<K;i++){
            int x1 = range[i][0];
            int y1 = range[i][1];
            int x2 = range[i][2];
            int y2 = range[i][3];

            int totalSum = dp[x2-1][y2-1];

            if(x1 != 1 && y1 != 1){
                totalSum = totalSum - dp[x1-2][y2-1] - dp[x2-1][y1-2] + dp[x1-2][y1-2];
            }else if(x1 != 1){
                totalSum = totalSum - dp[x1-2][y2-1];
            }else if(y1 !=1){
                totalSum = totalSum - dp[x2-1][y1-2];
            }

            System.out.println(totalSum);
        }
    }
}
