import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lan = new long[k];

        long maxLan = Long.MIN_VALUE;


        for(int i=0;i<k;i++){
            long temp = Long.parseLong(br.readLine());

            if(maxLan < temp) maxLan = temp;

            lan[i] = temp;

        }

        binarySearch(lan,1,maxLan,n);

        System.out.println(answer);
    }

    static public void binarySearch(long[] lan,long start,long end,int n){

        if(start > end) return;

        long mid = (start+end)/2;

        int temp = countLan(lan,mid);

        if(start == end){
            if(temp >= n) answer = mid;
            return;
        }
        
        if(temp >= n){
            answer = mid;
            binarySearch(lan,mid+1,end,n);
        }else{
            binarySearch(lan,start,mid,n);
        }
    }

    static public int countLan(long[] lan,long len){
        int count = 0;
        for(int i=0;i<lan.length;i++){
            count += lan[i] / len;
        }

        return count;
    }
}
