

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int answer1 = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);

        int answer2 = Integer.parseInt(a+b)-Integer.parseInt(c);
        
        System.out.println(answer1);
        System.out.println(answer2);
    }
}
