
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen+1][bLen+1];

        for(int i=1;i<aLen+1;i++){
            for(int j=1;j<bLen+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }

        String answer = dpToString(a,dp,aLen,bLen);

        if(answer.length() == 0){
            System.out.println(0);
        }else{
            System.out.println(answer.length());
            System.out.println(answer);
        }
    }

    public static String dpToString(String a,int[][] dp,int aIdx, int bIdx){
        Stack<Character> st = new Stack<>();
        String result = "";

        while(aIdx > 0 && bIdx > 0){
            if(dp[aIdx][bIdx] == dp[aIdx-1][bIdx]){
                aIdx--;
            }else if(dp[aIdx][bIdx] == dp[aIdx][bIdx-1]){
                bIdx--;
            }else{
                st.push(a.charAt(aIdx-1));
                aIdx--;
                bIdx--;
            }
        }

        while(!st.isEmpty()){
            result += st.pop();
        }

        return result;
    }
}
