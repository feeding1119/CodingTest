import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        Arrays.fill(dp,1);

        dp[0] = 1;

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(A[i]<A[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int maxValue = 0;

        for(int i=0;i<N;i++){
            maxValue = Math.max(maxValue,dp[i]);
        }
        System.out.println(maxValue);
    }
}
