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
	
	static boolean palin(String str) {
		int left=0;
		int right=str.length()-1;
		
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	static boolean pespalin(String str) {
		int left=0;
		int right=str.length()-1;
		
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right)) {
				String delstr1 = str.substring(0,left)+str.substring(left+1);
				String delstr2 = str.substring(0,right)+str.substring(right+1);
				if(palin(delstr1)||palin(delstr2)) {
					return true;
				}
				break;
			}
			left++;
			right--;
		}
		return false;
	}
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
        
    	int num = Integer.parseInt(sc.nextLine());
    	
    	for(int i=0;i<num;i++) {
    		String str = sc.nextLine();
    		
    		if(palin(str)) {
    			System.out.println("0");
    		}
    		else if(pespalin(str)) {
    			System.out.println("1");
    		}
    		else {
    			System.out.println("2");
    		}
    		
    	}
    	
    	
    }
}
