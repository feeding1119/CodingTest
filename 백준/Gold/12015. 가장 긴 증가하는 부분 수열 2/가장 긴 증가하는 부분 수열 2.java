

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];

        lis[0] = arr[0];
        int len = 1;

        for(int i=1;i<n;i++){

            int key = arr[i];

            if(lis[len-1] < key){
                lis[len++] = key;
            }else{
                int s = 0;
                int e = len-1;

                while(s<e){
                    int mid = (s+e)/2;

                    if(lis[mid] < key){
                        s = mid+1;
                    }else{
                        e = mid;
                    }
                }

                lis[s] = key;
            }


        }

        System.out.println(len);
    }

}
