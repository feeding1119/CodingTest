import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int len = N.length();

        int left = 0;
        for(int i=0;i<len/2;i++){
            left += (N.charAt(i)-'0');
        }

        int right = 0;
        for(int i=len/2;i<len;i++){
            right += (N.charAt(i)-'0');
        }

        if(left == right){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
