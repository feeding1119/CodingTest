import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        
        if(n==1){
            System.out.println(1);
            return;
        }

        long[][] answer = pow(new long[][]{{1,1},{1,0}},n-1);
        System.out.println(answer[0][0] % MOD);
    }

    public static long[][] pow(long[][] base, long exp){
        if(exp == 1) return base;

        long[][] half = pow(base,exp/2);
        long[][] halfSquared = multiply(half,half);

        if(exp%2==0) return halfSquared;
        else return multiply(halfSquared,base);
    }

    public static long[][] multiply(long[][] a,long[][] b){
        long[][] res = new long[2][2];

        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return res;
    }
}
