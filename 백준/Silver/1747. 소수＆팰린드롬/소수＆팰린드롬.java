import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=N;i<=Integer.MAX_VALUE;i++){
            if(isPrime(i) && isPellin(i)){
                System.out.println(i);
                break;
            }
        }

    }

    public static boolean isPellin(int n){

        StringBuilder sb = new StringBuilder();

        sb.append(n);
        sb.reverse();

        int m = Integer.parseInt(sb.toString());

        if(n == m) return true;
        return false;
    }
    public static boolean isPrime(int n){

        if(n == 1) return false;

        int temp = (int)Math.sqrt((double) n);

        for(int i=2;i<=temp;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
