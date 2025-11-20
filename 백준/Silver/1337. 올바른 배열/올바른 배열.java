

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 5;

        for(int i=0;i<n;i++){
            int count = 4;
            int value = arr[i]+5;
            for(int j=i+1;j<n;j++){
                if(arr[j] < value) count--;
            }

            answer = Math.min(answer,count);
        }

        System.out.println(answer);

    }
}
