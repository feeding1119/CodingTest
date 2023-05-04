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
    	
    	ArrayList<Double> costs =new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		costs.add(sc.nextDouble());
    	}
    	
    	Collections.sort(costs,Collections.reverseOrder());
    	
    	double total = costs.get(0);
    	for(int j=1;j<costs.size();j++) {
    		total += costs.get(j)/2;
    	}
    	
    	System.out.println(total);
    	
    }
}
