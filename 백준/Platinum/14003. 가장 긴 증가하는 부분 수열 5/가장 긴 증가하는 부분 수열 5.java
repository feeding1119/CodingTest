

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int[] idx = new int[n];

        int len = 1;


        lis[0] = arr[0];

        for(int i=1;i<n;i++){

            int key = arr[i];

            if(lis[len-1] < key){
                idx[i] = len;
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
                idx[i] = s;
            }


        }

        System.out.println(len);

        int[] result = new int[len];
        int target = len - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (idx[i] == target) {
                result[target] = arr[i];
                target--;
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
