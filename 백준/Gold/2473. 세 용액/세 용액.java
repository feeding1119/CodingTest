
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] value = new long[n];

        for(int i=0;i<n;i++){
            value[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(value);


        int[] answer = new int[3];
        long minCost = Long.MAX_VALUE;

        for(int i=0;i<n-2;i++){
            int start = i+1;
            int end = n-1;

            while(start<end){
                long total = value[i] + value[start] + value[end];

                if(Math.abs(total) < minCost){
                    minCost = Math.abs(total);
                    answer[0] = i;
                    answer[1] = start;
                    answer[2] = end;
                }

                if(total > 0) end--;
                else start++;
            }

            if(minCost == 0) break;
        }

        for(int i=0;i<3;i++){
            System.out.print(value[answer[i]]+" ");
        }

    }
}
