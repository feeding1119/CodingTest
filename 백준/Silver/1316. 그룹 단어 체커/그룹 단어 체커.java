import java.util.Scanner;

public class Main {
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	String num = sc.nextLine();
    	int n = Integer.parseInt(num); 
    	
    	int count = 0;
    	
    	for(int i=0;i<n;i++) {
    		String str = sc.nextLine();
    		boolean[] arr = new boolean[26];
    		char prev = ' ';
    		for(int j=0;j<str.length();j++) {
    			if(prev != str.charAt(j)) {
    				if(arr[str.charAt(j)-'a']==false) {
    					arr[str.charAt(j)-'a'] = true;
    				}
    				else {
    					count -= 1;
    					break;
    				}
    				
    			}
    			prev = str.charAt(j);
    		}
    		
    		count += 1;	
    	}
    	
    	System.out.print(count);
    	
    }
}
