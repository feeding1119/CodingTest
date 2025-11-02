

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] flavor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        flavor = new int[n][2];
        for(int i=0;i<n;i++){
             st = new StringTokenizer(br.readLine());

             int s = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             flavor[i][0] = s;
             flavor[i][1] = b;
        }

        dfs(0,1,0,0);

        System.out.println(answer);

    }

    public static void dfs(int idx,int s, int b,int count){
        if(idx == n){
            int temp = Math.abs(s-b);

            if(temp < answer && count > 0) answer = temp;
            return;
        }

        dfs(idx+1,s*flavor[idx][0],b+flavor[idx][1],count+1);
        dfs(idx+1,s,b,count);
    }
}
