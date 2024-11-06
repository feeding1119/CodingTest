import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] test = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            test[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        long answer = 0;
        for(int i=0;i<n;i++){
            int count = test[i] - b;
            answer++;

            if(count <= 0) continue;

            answer += count/c;

            if(count%c !=0) answer++;
        }

        System.out.println(answer);
    }
}
