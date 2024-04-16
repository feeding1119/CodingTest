import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
			int temp = Integer.parseInt(st.nextToken());
			if(temp % M == 0) System.out.print(temp+" ");
			else System.out.print(temp*M+" ");
		}
	}
}