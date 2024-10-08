

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp =new int[N+1];

        int answer = 0;
        for(int i=0;i<N;i++){
            int maxLen = 1;
            for(int j=0;j<i;j++){
                if(num[j] < num[i] && maxLen < dp[j]+1) maxLen = dp[j]+1;

            }

            dp[i] = maxLen;
            if(answer < maxLen) answer = maxLen;
        }

        System.out.println(answer);
    }
}
