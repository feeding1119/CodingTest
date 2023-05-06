import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

public class Main {
	

    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	int N = sc.nextInt();
    	int[] stair = new int[N+1];
    	
    	for(int i=1; i<N+1; i++) {
    		stair[i] = sc.nextInt();
    	}
    	
    	int[] dp = new int[N+1];
    	
    	dp[1] = stair[1];
    	
    	if(N > 1) {
    		dp[2] = stair[1] + stair[2];
    	}
    	
    	for(int i=3; i<N+1; i++) {
    		dp[i] = Math.max(dp[i-2],dp[i-3]+stair[i-1])+stair[i];
    	}
    	
    	System.out.print(dp[N]);
    }
}
