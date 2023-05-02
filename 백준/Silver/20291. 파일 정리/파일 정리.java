import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	int n = Integer.parseInt(sc.nextLine());
    	
    	String[] txts = new String[n];
    	int[] counts = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		String strs = sc.nextLine();
    		int index = strs.indexOf(".");
    		txts[i] =strs.substring(index+1);
    	}
    	
    	Arrays.sort(txts); 	
    	
    	String prevstr = txts[0];
    	int idx = 0;
    	int count = 1;
    	for(int j=1;j<txts.length;j++) {
    		if(prevstr.equals(txts[j])) {
    			count ++;
    		}
    		else {
    			counts[idx] = count;
    			count = 1;
    			idx++;
    		}
    		
    		if(j==txts.length-1) {
    			counts[idx] = count;
    		}
    		prevstr = txts[j];
    	}
    	
    	prevstr = txts[0];
    	idx = 0;
    	
    	System.out.print(prevstr+" ");
    	for(int k=1;k<txts.length;k++) {
    		if(!prevstr.equals(txts[k])) {
    			System.out.println(counts[idx]);
    			idx++;
    			System.out.print(txts[k]+" ");
    		}

    		
    		if (k==txts.length-1) {
    			System.out.println(counts[idx]);
    		}
    		prevstr = txts[k];
    	}
    }
}
