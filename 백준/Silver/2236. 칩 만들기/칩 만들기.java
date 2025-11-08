

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][2];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            map[i][0] = temp;
            map[i][1] = i+1;

        }

        Arrays.sort(map,(o1,o2) -> o1[0] - o2[0]);


        boolean[] check = new boolean[n+1];

        int count = 0;

        for(int i=n-1;i>=0;i--){
            check[map[i][1]] = true;

            count++;

            if(count == k) break;
        }

        for(int i=1;i<n+1;i++){
            if(check[i]) System.out.println(i);
        }

        if(k-count > 0){
            for(int i=0;i<k-count;i++){
                System.out.println(0);
            }
        }

        for(int i=1;i<n+1;i++){
            if(!check[i]) System.out.println(0);
            else System.out.println(i);
        }
    }

}
