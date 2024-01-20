import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] time = new int[N+1];
        int[] price = new int[N+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        for(int i=1; i<N+1;i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            int T = i+time[i];
            if(T<N+2) {
                dp[T] = Math.max(dp[T], dp[i] + price[i]);
            }
        }

        dp[N+1] = Math.max(dp[N+1],dp[N]);

        System.out.println(dp[N+1]);
    }

}