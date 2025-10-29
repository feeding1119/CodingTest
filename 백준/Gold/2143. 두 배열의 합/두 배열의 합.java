

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> aSum = new ArrayList<>();
        ArrayList<Long> bSum = new ArrayList<>();

        for(int i=0;i<n;i++){
            long temp = 0;
            for(int j=i;j<n;j++){
                temp += a[j];
                aSum.add(temp);
            }
        }

        for(int i=0;i<m;i++){
            long temp = 0;
            for(int j=i;j<m;j++){
                temp += b[j];
                bSum.add(temp);
            }
        }

        Collections.sort(aSum);
        Collections.sort(bSum);

        int left = 0;
        int right = bSum.size()-1;
        long answer = 0;

        while(left < aSum.size() && right >= 0){
            long as = aSum.get(left);
            long bs = bSum.get(right);

            long sum = as + bs;

            if(sum == t){
                long ac = 0;
                long bc = 0;

                while(left < aSum.size() && as == aSum.get(left)){
                    left++;
                    ac++;
                }

                while(right >=0 && bs == bSum.get(right)){
                    right--;
                    bc++;
                }

                answer += ac*bc;
            }else if(sum > t){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(answer);


    }
}
