import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[1000001];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ice[x] = g;
        }

        int start = 0;
        int end = 2*K+1;
        int amount = 0;
        int maxAmount = 0;

        for(int i=start;i<=end;i++){
            if(i==1000001) break;

            amount += ice[i];
        }

        maxAmount = amount;

        while(end<1000000){
            amount -= ice[start];
            amount += ice[end+1];

            start++;
            end++;

            if(maxAmount<amount){
                maxAmount=amount;
            }
        }

        System.out.println(maxAmount);
    }
}
