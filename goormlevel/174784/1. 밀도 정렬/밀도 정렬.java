import java.io.*;
import java.util.*;
class Main {
	
	static class Things implements Comparable<Things>{
		int w;
		int v;
		int index;
		double d;
		
		Things(int w,int v,int index){
			this.w = w;
			this.v = v;
			this.index = index;
			this.d = (double)w/(double)v;
		}
		
		@Override
		public int compareTo(Things o){
			if(this.d == o.d){
				return o.w - this.w;
			}
			return Double.compare(o.d , this.d);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		List<Things> th = new ArrayList<>();
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			th.add(new Things(w,v,i));
		}
		
		Collections.sort(th);
		
		System.out.println(th.get(0).index);
		
	}
}