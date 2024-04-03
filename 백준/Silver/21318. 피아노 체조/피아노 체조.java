import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] level = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            level[i] = Integer.parseInt(st.nextToken());
        }

        int[] countSum = new int[N+1];

        for(int i=1;i<=N;i++){
            if(level[i-1]>level[i]){
                countSum[i] = countSum[i-1]+1;
            }else{
                countSum[i] = countSum[i-1];
            }
        }


        int Q = Integer.parseInt(br.readLine());

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(countSum[e]-countSum[s]);
        }
    }
}
