

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] rating = new int[n+1];

        rating[0] = x;

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++){
            rating[i] = rating[i-1] + Integer.parseInt(st.nextToken());
        }

        int[] count = new int[n+1];

        if(x < k) count[0] = 1;

        for(int i=1;i<n+1;i++){
            count[i] = count[i-1];

            if(rating[i] < k) count[i] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(count[r-1] - count[l-1]).append("\n");
        }


        System.out.print(sb);
    }
}
