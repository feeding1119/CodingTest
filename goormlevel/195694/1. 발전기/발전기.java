import java.io.*;
import java.util.*;

// dfs에는 재귀 제한이 걸리나보다..

class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] v;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map= new int[N][N];
		v = new boolean[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!v[i][j] && map[i][j] == 1){
					bfs(i,j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	
		
	}
	
	public static void bfs(int x,int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		v[x][y] = true;
		
		while(!q.isEmpty()){
			int[] position = q.poll();
			
 			for(int i=0;i<4;i++){
			int nx = position[0] + dx[i];
			int ny = position[1] + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N){
				if(!v[nx][ny] && map[nx][ny] == 1){
					v[nx][ny] = true;
					q.offer(new int[]{nx,ny});
				} 
			}
		}
		}
		
	}
}