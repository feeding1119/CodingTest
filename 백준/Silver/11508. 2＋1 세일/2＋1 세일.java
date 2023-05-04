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
    	
    	ArrayList<Integer> costs =new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		costs.add(sc.nextInt());
    	}
    	
    	Collections.sort(costs,Collections.reverseOrder());
    	
    	int total = 0;
    	for(int j=0;j<costs.size();j++) {
    		if ((j+1)%3!=0) {
    			total = total + costs.get(j);
    		}
    	}
    	
    	System.out.println(total);
    	
    }
}
