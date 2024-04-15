import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		
		for(int i=0;i<N;i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int maxValue = num[0];
		int tempSum = num[0];
		
		for(int i=1;i<N;i++){
			if(num[i] > maxValue) maxValue=num[i];
			
			if(num[i]-num[i-1] == 1){
				tempSum += num[i];
			}else{
				if(tempSum != 0){
					if(maxValue < tempSum) maxValue = tempSum;
					tempSum = num[i];
				}
			}
		}
		
		if(tempSum != 0){
			if(maxValue < tempSum) maxValue = tempSum;
		}
		
		System.out.print(maxValue);
		
	}
}