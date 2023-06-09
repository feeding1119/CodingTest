import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	String num = sc.nextLine();
    	int n = Integer.parseInt(num); 
    	
    	String[] arr = new String[n];
    	
    	for(int i=0;i<n;i++) {
    		String str = sc.nextLine();
    		arr[i] = str;
    	}
    	
    	Arrays.sort(arr,new Comparator<String>() {
    		@Override
    		public int compare(String s1, String s2) {
    			if(s1.length() == s2.length()) {
    				return s1.compareTo(s2);
    			}
    			else {
    				return s1.length() - s2.length();
    			}
    		}
    	});
    	
    	System.out.println(arr[0]);	
    	for(int i=1; i<n;i++) {
    		if(!arr[i].equals(arr[i-1])) {
    			System.out.println(arr[i]);
    		}
    	}
    }
}
