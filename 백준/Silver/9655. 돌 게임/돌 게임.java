import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+4];

        dp[1]=1;

        for(int i=2;i<=N;i++){
            if(dp[i]==1){
                dp[i+1] = 2;
                dp[i+3] = 2;
            }else{
                dp[i+1] = 1;
                dp[i+3] = 1;
            }
        }

        if(dp[N]==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }

    }
}
