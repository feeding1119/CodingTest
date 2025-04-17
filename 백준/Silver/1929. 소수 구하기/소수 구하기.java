import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        for(int i=m;i<=n;i++){
            if(i==1) continue;
            if(isPrime(i)) sb.append(i+"\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int n){
        int temp = (int)Math.sqrt(n);
        for(int i=2;i<=temp;i++){
            if(n%i==0) return false;
        }

        return true;
    }
}
