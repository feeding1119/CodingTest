import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] values = new int[N][2];
		double[] answer = new double[N];
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			values[i][0] = Integer.parseInt(st.nextToken());
			values[i][1] = Integer.parseInt(st.nextToken());
		}
		
		double maxValue = 0;
		int maxIndex = 0;
		
		for(int i=0;i<N;i++){
			answer[i] = (double)values[i][0]/(double)values[i][1];
	
			if(answer[i] > maxValue) {
				maxValue = answer[i];
				maxIndex = i;
			}else if(answer[i] == maxValue){
				
				if(values[i][0] > values[maxIndex][0]){
					maxValue = answer[i];
					maxIndex = i;
					
				}
			}
		}
		
	
		System.out.println(maxIndex+1);
	}
}