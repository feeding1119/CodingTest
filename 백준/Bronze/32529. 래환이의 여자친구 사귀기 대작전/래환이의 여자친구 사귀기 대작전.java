
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int w = 0;
        int answer = -1;

        for(int i=n-1;i>=0;i--){
            w += a[i];

            if(w >= m){
                answer = i+1;
                break;
            }
        }

        System.out.println(answer);


    }
}
