import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] power = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            power[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        dp[1] = 1;

        int result = 1;

        for(int i=2;i<=N;i++){
            int maxValue = 0;
            for(int j=1;j<=i;j++){
                if(power[i-1]<power[j-1] && maxValue<dp[j]){
                    maxValue=dp[j];
                }
            }
            dp[i] = maxValue+1;
            if(dp[i]> result) result=dp[i];
        }


        System.out.println(N-result);


    }
}
