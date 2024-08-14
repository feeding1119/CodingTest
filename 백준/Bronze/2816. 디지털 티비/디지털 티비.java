

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] channels = new String[N];

        for(int i=0;i<N;i++){
            channels[i] = br.readLine();
        }

        int KBS1 = 0;
        for(int i=0;i<N;i++){
            if(channels[i].equals("KBS1")) KBS1 = i;
        }

        for(int i=0;i<KBS1;i++){
            System.out.print("1");
        }
        for(int i=0;i<KBS1;i++){
            System.out.print("4");
        }

        System.out.print("1");

        int KBS2 = 0;
        for(int i=0;i<N;i++){
            if(channels[i].equals("KBS2")) KBS2 = i;
        }
        if(KBS2 < KBS1) KBS2++;

        for(int i=1;i<KBS2;i++){
            System.out.print("1");
        }
        for(int i=1;i<KBS2;i++){
            System.out.print("4");
        }
    }
}
