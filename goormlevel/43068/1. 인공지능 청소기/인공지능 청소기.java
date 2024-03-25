import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int X,Y,N,total;
		
		
		while(T>0){
			st = new StringTokenizer(br.readLine());
			
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			total = Math.abs(X) + Math.abs(Y);
			
			if(total>N) {
				System.out.println("NO");
			}else if((total-N) % 2 == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			T--;
		}
	}
}