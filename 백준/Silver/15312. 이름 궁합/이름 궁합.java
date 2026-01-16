

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        int n = a.length();

        String name = "";

        for(int i=0;i<n;i++){
            name += arr[a.charAt(i)-'A'];
            name += arr[b.charAt(i)-'A'];
        }

        while(true){
            String temp = "";

            n = name.length();

            for(int i=0;i<n-1;i++){
                int value = (name.charAt(i)-'0' + name.charAt(i+1)-'0') % 10;

                temp += value;
            }

            name = temp;

            if(name.length() == 2) break;
        }

        System.out.println(name);
    }
}
