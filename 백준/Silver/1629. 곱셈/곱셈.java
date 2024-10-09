

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());


        System.out.println(pow(A,B,C));
    }

    public static long pow(long a, long exp,long c){
        if(exp == 1){
            return a % c;
        }

        long temp = pow(a,exp/2,c);

        if(exp%2 == 1){
            return (temp*temp%c) * a%c;
        }

        return temp*temp%c;
    }
}
