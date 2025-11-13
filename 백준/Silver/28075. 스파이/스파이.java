

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] work;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        work = new int[7];

        int idx = 1;
        for(int i=0;i<2;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                work[idx++] = Integer.parseInt(st.nextToken());
            }

        }
        dfs(0,0,-1);

        System.out.println(answer);

    }

    public static void dfs(int day,int total,int prev){
        if(day == n){
            if(total >= m) answer++;
            return;
        }

        for(int i=1;i<7;i++){
            if(i%3 == prev) dfs(day+1,total+work[i]/2,i%3);
            else dfs(day+1,total+work[i],i%3);
        }
    }
}
