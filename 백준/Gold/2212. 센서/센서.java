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
        
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int[] costs = new int[n];
    	
    	if(m>=n) {
    		System.out.println("0");
    	}
    	else {
    		for(int i=0;i<n;i++) {
        		costs[i] = sc.nextInt();
        	}
        	
        	Arrays.sort(costs);
        	
        	Integer[] dist = new Integer[n-1];

        	for(int i=0;i<n-1;i++) {
        		dist[i]=costs[i+1]-costs[i];
        	}
        	
        	Arrays.sort(dist,Collections.reverseOrder());
        	
        	int sum = 0;
        	
        	for(int j= m-1;j<n-1;j++) {
        		sum += dist[j];
        	}
        	System.out.println(sum);
    	}
    	
    
    
    
    }
}
