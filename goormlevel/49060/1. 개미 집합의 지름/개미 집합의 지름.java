import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] P = new int[N];
		int[] ant = new int[2000001];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
			int p = Integer.parseInt(st.nextToken());
			
			P[i] = p;
			ant[p]++;
		}
		
		Arrays.sort(P);
		
		int start = P[0];
		int end = P[0]+D;
		int temp = 0;
		
		for(int i=start;i<=end;i++){
			temp += ant[i];
		}
		int answer = temp;
		
		while(end<P[N-1]){
			temp -= ant[start++];
			temp += ant[++end];
			
			if(temp > answer) answer=temp;
		}
		
		System.out.println(N-answer);
		
	}

		
}