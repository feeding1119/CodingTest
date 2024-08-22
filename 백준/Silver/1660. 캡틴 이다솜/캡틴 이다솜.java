
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] count= new int[301];

        int plus = 2;
        count[1] = 1;
        for(int i=2;i<=300;i++){
            count[i] = count[i-1] + (count[i-1]-count[i-2]) + plus++;
        }

        int[] dp = new int[N+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[1] = 1;

        for(int i=2;i<=N;i++){
            int index = 1;
            while(true){
                if(i - count[index] < 0) break;

                if(i - count[index] ==0) {
                    dp[i] = 1;
                    break;
                }

                if(dp[i-count[index]] != Integer.MAX_VALUE){

                    dp[i] = Math.min(dp[i],dp[i-count[index]]+1);
                }

                index++;

            }
        }
        
        System.out.println(dp[N]);


    }
}
