import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        if(N<10) N *=10;
        int count = 0;

        int transN = N;

        while(true){
            transN = trans(transN);
            count++;

            if(transN == N) break;

        }

        System.out.println(count);

    }
    public static int trans(int n){
        

        int first = n/10;
        int second = n%10;

        return second*10 + (first + second)%10;
    }

}
