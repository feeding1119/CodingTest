
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] count= new int[301];
        int[] dp = new int[N+1];

        for(int i=0;i<=N;i++){
            dp[i] = i;
        }

        int plus = 2;
        count[1] = 1;
        for(int i=2;i<=300;i++){
            count[i] = count[i-1] + (count[i-1]-count[i-2]) + plus++;
            if(count[i] <=N ) dp[count[i]] = 1;
        }


        for(int i=2;i<=N;i++){
            int index = 1;
            while(true){
                int diff = i - count[index++];
                if(diff < 0) break;

                dp[i] = Math.min(dp[i],dp[diff]+1);
            }
        }

        System.out.println(dp[N]);


    }
}
