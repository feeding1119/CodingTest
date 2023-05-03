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
        
    	int T = Integer.parseInt(sc.nextLine());
    	
    	for(int t=0;t<T;t++) {
    		String W = sc.nextLine();
        	int K = Integer.parseInt(sc.nextLine());
    		
        	if(K==1) {
        		System.out.println("1 1");
        		continue;
        	}
        	HashMap<Character,Integer> map = new HashMap<>();
        	
        	for(int i=0;i<W.length();i++) {
        		map.put(W.charAt(i),map.getOrDefault(W.charAt(i),0)+1);
        	}
       
        	List<Character> constr = new ArrayList<>();
        	
        	for(char key : map.keySet()) {
        		
        		if(map.get(key)>=K) {
        			constr.add(key);
        		}
        	}
        	
        	
        	int minl = 10001;
        	int maxl = -1;
        	if(constr.size()==0) {
        		System.out.println("-1");
        	}
        	else {
        		for(int j=0;j<W.length();j++) {
        			if(!constr.contains(W.charAt(j))) {
        				continue;
        			}
        			
        			int count = 1;
        			
        			for(int k=j+1;k<W.length();k++) {
        				if(W.charAt(j)==W.charAt(k)) {
        					count++;
        				}
        				
        				if(count==K) {
        					minl = Math.min(minl,k-j+1);
        					maxl = Math.max(maxl,k-j+1);
        					break;
        				}
        			}
            	}
        		
        		System.out.println(minl+" "+maxl);
        	}
        	
    	}
    	
    	
    	
    }
}
