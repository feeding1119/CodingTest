import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i=4;i<=N;i++){
            if(dp[i-1]==1||dp[i-3]==1){
                dp[i] = 2;
            }else{
                dp[i] = 1;
            }
        }

        if(dp[N]==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }

    }
}
