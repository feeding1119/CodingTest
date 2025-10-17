

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        double answer = 0;

        for(int i=0;i<n;i++){
            answer += (double) arr[i][0] * arr[(i+1)%n][1];
            answer -= (double) arr[(i+1)%n][0] * arr[i][1];
        }

        answer = Math.abs(answer)/2;

        System.out.printf("%.1f",answer);
    }
}
