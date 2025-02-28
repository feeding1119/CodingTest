import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        int total = 0;
        boolean firstCheck = false;

        while(st.hasMoreTokens()){
            StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");

            int temp = 0;

            while(plus.hasMoreTokens()){
                temp += Integer.parseInt(plus.nextToken());
            }

            if(!firstCheck){
                total += temp;
                firstCheck = true;
            }else{
                total -= temp;
            }
        }

        System.out.println(total);
    }
}
