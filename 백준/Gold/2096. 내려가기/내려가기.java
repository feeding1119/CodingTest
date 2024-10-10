
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class AnsNode{
    int maxValue;
    int minValue;

    AnsNode(int maxValue,int minValue){
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        AnsNode[][] dp = new AnsNode[N][3];

        for(int i=0;i<3;i++){
            dp[0][i] = new AnsNode(map[0][i],map[0][i]);
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                int maxV = Integer.MIN_VALUE;
                int minV = Integer.MAX_VALUE;


                if(j-1 >= 0){
                    maxV = Math.max(maxV,dp[i-1][j-1].maxValue + map[i][j]);
                    minV = Math.min(minV,dp[i-1][j-1].minValue + map[i][j]);
                }

                maxV = Math.max(maxV,dp[i-1][j].maxValue + map[i][j]);
                minV = Math.min(minV,dp[i-1][j].minValue + map[i][j]);


                if(j+1 < 3){
                    maxV = Math.max(maxV,dp[i-1][j+1].maxValue + map[i][j]);
                    minV = Math.min(minV,dp[i-1][j+1].minValue + map[i][j]);
                }

                dp[i][j] = new AnsNode(maxV,minV);
            }
        }

        int maxAnswer = Integer.MIN_VALUE;
        int minAnswer = Integer.MAX_VALUE;

        
        for(int i=0;i<3;i++){
            maxAnswer = Math.max(maxAnswer,dp[N-1][i].maxValue);
            minAnswer = Math.min(minAnswer,dp[N-1][i].minValue);
        }

        System.out.println(maxAnswer +" "+minAnswer);

    }
}
