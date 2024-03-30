import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] values = new long[N];

        for(int i=0;i<N;i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        long minAnswer = Long.MAX_VALUE;
        long minA = 0;
        long minB = 0;

        int start = 0;
        int end = N-1;

        while(start<end){
            long temp = values[start]+values[end];

            if(minAnswer > Math.abs(temp)){
                minAnswer = Math.abs(temp);
                minA = values[start];
                minB = values[end];
            }

            if(temp < 0){
                start++;
            }else{
                end--;
            }
        }

        System.out.print(minA+" "+minB);

    }
}
