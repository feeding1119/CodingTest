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

        int[] arr = new int[N];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        boolean prev = true;
        while(end<N){
            if(prev) count[arr[end]]++;
            if(count[arr[end]] > K){
                count[arr[start]]--;
                prev = false;
                start++;
            }else{
                if(answer<end-start) answer = end-start;
                prev = true;
                end++;
            }

        }
        System.out.println(answer+1);


    }
}
