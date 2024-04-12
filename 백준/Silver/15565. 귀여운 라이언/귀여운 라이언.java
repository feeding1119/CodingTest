
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

        int[] doll = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            doll[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int answer = Integer.MAX_VALUE;

        if(doll[0] == 1) count++;


        while(end<N){
            if(count == K){
                if(end-start+1 < answer) answer = end-start+1;

                if(doll[start] == 1) count--;
                start++;

            }else{
                end++;

                if(end!=N && doll[end] == 1) count++;
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);

        }else{
            System.out.println(answer);

        }


    }
}
