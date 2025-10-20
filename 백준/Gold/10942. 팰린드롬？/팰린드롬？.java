
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] seq;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        seq = new int[n+1];
        dp = new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i!=0 && i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = -1;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp(s,e)).append("\n");
        }

        System.out.println(sb);
    }


    public static int dp(int s,int e){
        if(dp[s][e] != -1) return dp[s][e];
        if(seq[s] != seq[e]) return dp[s][e] = 0;

        if(e-s < 3){
            if(seq[s] == seq[e]) return dp[s][e] = 1;
            else return dp[s][e] = 0;
        }

        return dp[s][e] = dp(s+1,e-1);
    }
}
