import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] dp = new int[K+1];
		
		dp[0] = 1;
		dp[1] = 0;
		for(int i=2;i<=K;i++){
			dp[i]=(dp[i-1]+dp[i-2])%1000000007;
		}
		
		System.out.print(dp[K]%1000000007);
	}
}