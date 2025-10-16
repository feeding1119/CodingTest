
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[n+2];

        for(int i=1;i<n+1;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+2][2];

        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                if(seq[i] > seq[j]) dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            }
        }

        for(int i=n;i>=1;i--){
            for(int j=i+1;j<n+2;j++){
                if(seq[i] > seq[j]) dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }
        }

        int answer = 1;

        for(int i=1;i<n+1;i++){
            int up = 0;
            int upidx = 0;
            for(int j=1;j<=i;j++){
                if(up < dp[j][0]){
                    up = dp[j][0];
                    upidx = j;
                }
            }

            int down = 0;
            for(int j=i+1;j<n+1;j++){
                if(seq[upidx] != seq[j]) down = Math.max(down,dp[j][1]);
            }

            answer = Math.max(answer, up+down);
        }

        System.out.println(answer);

    }
}
