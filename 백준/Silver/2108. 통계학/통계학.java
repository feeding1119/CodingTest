

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] countArr = new int[8001];

        int total = 0;

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            countArr[temp+4000]++;

            total += temp;
        }

        int maxCount = 0;
        int answer = 0;

        boolean flag = false;

        for(int i=0;i<8001;i++){
            if(countArr[i] == 0) continue;

            if(countArr[i] > maxCount){
                maxCount = countArr[i];
                answer = i-4000;
                flag = true;
            }else if(flag && maxCount == countArr[i]){
                answer = i-4000;
                flag = false;
            }

        }

        Arrays.sort(arr);

        System.out.println((int)Math.round((double)total/n));
        System.out.println(arr[n/2]);
        System.out.println(answer);
        System.out.println(arr[n-1]-arr[0]);


    }
}
