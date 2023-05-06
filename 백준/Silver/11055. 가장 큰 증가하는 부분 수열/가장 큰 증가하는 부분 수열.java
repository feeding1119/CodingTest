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
    	int[] num = new int[N+1];
    	
    	for(int i=1; i<N+1; i++) {
    		num[i] = sc.nextInt();
    	}
    	
    	int[] dp = new int[N+1];
    	
    	dp[1] = num[1];
    	
    	for(int i=2;i<N+1;i++) {
    		dp[i] = num[i];
    		for(int j=1;j<i;j++) {
    			if(num[i]>num[j]) {
    				dp[i]=Math.max(dp[i],dp[j]+num[i]);
    			}
    		}
    	}
    	
    	int maxNum = 0;
    	
    	for(int i=1;i<N+1;i++) {
    		if(maxNum<dp[i]) {
    			maxNum = dp[i];
    		}
    	}
    	
    	System.out.println(maxNum);
    }
}
