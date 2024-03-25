import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] house = new int[N];
		int[] range = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j=start-1;j<end;j++){
				house[j]++;
				range[j] = 1;
			}
			
			if(i%3==2){
				for(int k=0;k<N;k++){
					if(range[k]==1) house[k]--;
				}
				range = new int[N];
			}
			
		}
		
		for(int i=0;i<N;i++){
			System.out.print(house[i]+" ");
		}
	}
}