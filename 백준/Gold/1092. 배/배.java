import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

public class Main {
	

    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	int N = sc.nextInt();
    	ArrayList<Integer> wLimit = new ArrayList<>();
    	
    	for(int i=0;i<N;i++) {
    		wLimit.add(sc.nextInt());
    	}
    	
    	int M = sc.nextInt();
    	ArrayList<Integer> box = new ArrayList<>();
    	
    	for(int i=0;i<M;i++) {
    		box.add(sc.nextInt());
    	}
    	
    	Collections.sort(wLimit,Collections.reverseOrder());
    	Collections.sort(box,Collections.reverseOrder());
    	
   
    	if(box.get(0)>wLimit.get(0)) {
    		System.out.println("-1");
    	}
    	else {
    		int count = 0;
    		int time = 0;
    		while(box.size()!=0) {
    			for(Iterator<Integer> iter = box.iterator();iter.hasNext();) {
    				
    				if(wLimit.get(count)>=iter.next()) {
    					count++;
    					iter.remove();	
    				}
    				if(count==N) {
    					break;
    				}
    			}
    			
    			count=0;
				time++;
    				
    		}
    		
    		System.out.println(time);
    	}
    
    }
}
