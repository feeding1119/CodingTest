import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer,Integer> map = new HashMap<>();
		
		boolean isNone = true;
		for(int i=1;i<=M;i++){
			map.put(Integer.parseInt(br.readLine()),1);
			
			if(map.size() == N){
				System.out.print(i);
				isNone = false;
				break;
			}
		}
		
		if(isNone) System.out.print(-1);
	}
}