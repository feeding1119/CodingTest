

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int s,c;
    static int[] pa;
    static long maxLen = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pa = new int[s];

        long maxPa = 0;
        long total = 0;
        for(int i=0;i<s;i++){
            int temp = Integer.parseInt(br.readLine());
            pa[i] = temp;
            total += pa[i];
            if(maxPa < temp) maxPa = temp;
        }

        binarySearch(1L,maxPa);

        System.out.println(total - maxLen*c);
    }

    public static void binarySearch(long start,long end){
        if(start > end){
            return;
        }

        long mid = (start+end)/2;

        long count = 0;
        for(int i=0;i<s;i++){
            count += pa[i]/mid;
        }

        if(count >= c){
            maxLen = Math.max(maxLen,mid);
            binarySearch(mid+1,end);
        }else{
            binarySearch(start,mid-1);
        }

    }
}
