import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[0] = 1;
        dp[1] = 1;
        //dp[n] = dp[n-2]*2+dp[n-1]
        //3 5 4 11 5 21 6 43 7 85 81 171
        for(int i=2; i<1001;i++){
            dp[i] = (2*dp[i-2])%10007 + dp[i-1]%10007;
        }

        System.out.println(dp[n]%10007);

    }
}
