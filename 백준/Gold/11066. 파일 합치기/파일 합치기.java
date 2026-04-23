
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] files = new int[n+1];
            int[] prefixSum = new int[n+1];
            int[][] dp = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                files[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i-1] + files[i];
            }

            for(int len=2;len<=n;len++){
                for(int start=1;start+len-1<= n;start++){
                    int end = start+len-1;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int k = start;k<end;k++){
                        int cost = dp[start][k] + dp[k+1][end] + (prefixSum[end]-prefixSum[start-1]);

                        dp[start][end] = Math.min(dp[start][end],cost);
                    }
                }
            }

            sb.append(dp[1][n]).append("\n");

        }

        System.out.println(sb);
    }
}
