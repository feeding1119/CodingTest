import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	while(sc.hasNext()) {
    		String str = sc.nextLine();
        	String[] strs = str.split(" ");
        	
        	int cidx = 0;
        	String result = "No";
        	for(int i=0;i<strs[1].length();i++) {
        		if(strs[0].charAt(cidx)==strs[1].charAt(i)) {
        			cidx++;
        		}
        		if(strs[0].length()==cidx) {
        			result = "Yes";
        			break;
        		}
        	}
        	
        	System.out.println(result);
    	}
    	
    }
}
