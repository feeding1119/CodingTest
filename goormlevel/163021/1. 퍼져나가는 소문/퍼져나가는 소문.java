import java.io.*;
import java.util.*;

class Main {
	
	static int N,M;
	static boolean[][] friend;
	static boolean[] v;
	
	static int answer = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		friend = new boolean[N+1][N+1];
		v = new boolean[N+1];
		
		StringTokenizer st;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b] = true;
			friend[b][a] = true;
		}
		
		dfs(1);
		
		System.out.print(answer);
	}
	
	static void dfs(int n){
		v[n] = true;
		
		for(int i=0;i<=N;i++){
			if(friend[n][i]&&!v[i]){
				dfs(i);
				answer++;
			}
		}
	}
}