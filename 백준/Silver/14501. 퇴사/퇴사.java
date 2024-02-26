import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];

        StringTokenizer st;

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N+6];

        int maxValue =0;
        for(int i=1;i<=N;i++){
            if(dp[i] > maxValue) maxValue=dp[i];
            dp[i+T[i]] =Math.max(dp[i+T[i]],maxValue + P[i]);
        }

        if(dp[N+1]>maxValue) maxValue = dp[N+1];

        System.out.println(maxValue);
    }
}
