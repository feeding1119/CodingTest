

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] house = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int dist = Integer.parseInt(st.nextToken());
            house[i] = dist;
        }

        Arrays.sort(house);

        if(N%2==0){
            System.out.println(house[N/2-1]);
        }else{
            System.out.println(house[N/2]);
        }
        

    }
}
