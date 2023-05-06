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
        
    	int N = sc.nextInt();
    	ArrayList<Integer> honey = new ArrayList<>();
    	int maxHoney = 0;
    	int bee1,bee2;
    	
    	for(int i=0;i<N;i++) {
    		honey.add(sc.nextInt());
    	}
    	
    	int[] toLeftTotal = new int[N];
    	int[] toRightTotal = new int[N];
    	
    	int temp = 0;
    	
    	for(int i=0;i<N;i++) {
    		temp += honey.get(i);
    		toRightTotal[i] = temp;
    	}
    	
    	temp = 0;
    	for(int i=N-1;i>=0;i--) {
    		temp += honey.get(i);
    		toLeftTotal[i]=temp;
    	}
    	
    	for(int i=1;i<N-1;i++) {
    		bee1 = toRightTotal[N-1] - honey.get(0) - honey.get(i);
    		bee2 = toRightTotal[N-1] - toRightTotal[i];
    		maxHoney = Math.max(maxHoney, bee1 + bee2);
    	}
    	
    	for(int i=N-2;i>=0;i--) {
    		bee1 = toLeftTotal[0] - honey.get(N-1) - honey.get(i);
    		bee2 = toLeftTotal[0] - toLeftTotal[i];
    		maxHoney = Math.max(maxHoney, bee1 + bee2);
    	}
    	
    	for(int i=1;i<N-1;i++) {
    		bee1 = toRightTotal[i] - honey.get(0);
    		bee2 = toLeftTotal[i] - honey.get(N-1);
    		maxHoney = Math.max(maxHoney, bee1 + bee2);
    	}
    	
    	System.out.print(maxHoney);
    }
}
