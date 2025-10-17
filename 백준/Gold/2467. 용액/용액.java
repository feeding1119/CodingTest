

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] info = new int[n];

        for(int i=0;i<n;i++){
            info[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;

        int answer = Integer.MAX_VALUE;
        int[] ansIdx = new int[2];

        while(start < end){
            int temp = info[start]+info[end];

            if(Math.abs(temp) <= answer){
                answer = Math.abs(temp);
                ansIdx[0] = start;
                ansIdx[1] = end;
            }

            if(temp > 0) end--;
            else start++;

        }
        System.out.println(info[ansIdx[0]] + " " + info[ansIdx[1]]);
    }
}
