

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[][] stats;
    static int n;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        v = new boolean[n+1];

        stats = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=n;j++){
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(1,0);

        System.out.println(answer);
    }

    static public void dfs(int idx,int count){
        if(count == n/2){
            clacScore();
            return;
        }

        for(int i=idx;i<=n;i++){
            if(!v[i]){
                v[i] = true;
                dfs(i+1,count+1);
                v[i] = false;
            }
        }
    }

    static public void clacScore(){
        int team1 = 0;
        int team2 = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(v[i] && v[j]) team1 += stats[i][j];
                if(!v[i] && !v[j]) team2 += stats[i][j];
            }
        }

        int result = Math.abs(team1-team2);

        if(answer > result) answer = result;
    }
}
