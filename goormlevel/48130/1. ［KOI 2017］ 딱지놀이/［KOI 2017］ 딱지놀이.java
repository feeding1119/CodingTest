import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	static int[] aList;
	static int[] bList;
	static StringTokenizer st;
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++){
			aList = new int[4];
		  bList = new int[4];
			
			insertValue('a');
			insertValue('b');
			
			compareValue(3);
		}
		
		System.out.println();
	}
	private static void insertValue(char value) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		st.nextToken();
		if(value=='a'){
			while(st.hasMoreTokens()){
				aList[Integer.parseInt(st.nextToken())-1]++;
			}
		}else if(value=='b'){
			while(st.hasMoreTokens()){
				bList[Integer.parseInt(st.nextToken())-1]++;
			}
		}
	}
	private static void compareValue(int n){
		if(n == -1) {
			System.out.println("D");
			return;
		}
		if(aList[n]>bList[n]){
			System.out.println("A");
		}else if(aList[n]<bList[n]){
			System.out.println("B");
		}else{
			compareValue(n-1);
		}
	}
}