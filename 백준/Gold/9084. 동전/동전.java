
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                int coin = coins[i];

                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");

        }

        System.out.println(sb);
    }

}
