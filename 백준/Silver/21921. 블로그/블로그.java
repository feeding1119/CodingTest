

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] blog = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            blog[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = X-1;

        int total = 0;

        for(int i=start;i<=end;i++){
            total += blog[i];
        }
        start++;
        end++;

        int maxVisited = total;
        int count = 1;
        while(end < N){

            total -= blog[start-1];
            total += blog[end];

            if(total>maxVisited){
                count = 1;
                maxVisited = total;
            }else if(total == maxVisited){
                count++;
            }

            start++;
            end++;

        }

        if(maxVisited==0){
            System.out.println("SAD");
        }else{
            System.out.println(maxVisited);
            System.out.println(count);
        }
    }
}
