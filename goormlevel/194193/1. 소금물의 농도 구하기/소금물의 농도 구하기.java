import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double N = Integer.parseInt(st.nextToken());
		double M = Integer.parseInt(st.nextToken());
		
		double salt = N*0.07;
		
		double result = salt/(N+M)*100;
		System.out.printf("%.2f",Math.floor(result*100)/100.0);
	}
}