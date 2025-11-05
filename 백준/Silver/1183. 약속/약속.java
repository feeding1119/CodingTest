

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] diff = new int[n];

        int answer = 0;

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            diff[i] = b-a;
        }

        Arrays.sort(diff);


        if(n%2==1) System.out.println(1);
        else System.out.println(Math.abs(diff[n/2]-diff[n/2-1]+1));


    }

}
