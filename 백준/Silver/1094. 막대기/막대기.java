

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        String xb = Integer.toBinaryString(X);

        int answer = 0;
        for(int i=0;i<xb.length();i++){
            if(xb.charAt(i) == '1') answer++;
        }

        System.out.println(answer);
    }
}
