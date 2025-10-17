import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long[] num = new long[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++){
            num[i] = num[i-1] + Long.parseLong(st.nextToken());
        }



        int answer = Integer.MAX_VALUE;

        int start = 1;
        int end = 1;
        while(start <= end && start < n+1 && end <n+1){

            long temp = num[end] - num[start-1];

            if(temp >= s){
                answer = Math.min(answer,end-start+1);
                
                if(start == end) end++;
                start++;
            }else{
                end++;
            }
        }

        if(answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);

    }
}
