
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> order = new ArrayList<>();

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            
            if(n != 0) order.add(n);
        }

        if(order.isEmpty()){
            System.out.println(0);
            return;
        }

        int[][] cost = {
                {1,2,2,2,2},
                {0,1,3,4,3},
                {0,3,1,3,4},
                {0,4,3,1,3},
                {0,3,4,3,1}};

        int[][][] dp = new int[order.size()+1][5][5];

        for(int i=0;i<order.size()+1;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }


        dp[0][0][0] = 0;

        for(int i=0;i<order.size();i++){

            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(dp[i][j][k] != Integer.MAX_VALUE){
                        int temp = order.get(i);
                        dp[i+1][temp][k] = Math.min(dp[i+1][temp][k],dp[i][j][k] + cost[j][temp]);
                        dp[i+1][j][temp] = Math.min(dp[i+1][j][temp],dp[i][j][k] + cost[k][temp]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(answer > dp[order.size()][i][j]) answer = dp[order.size()][i][j];
            }
        }

        System.out.println(answer);



    }
}
