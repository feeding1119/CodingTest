import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long n;
    static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        binarySearch(0,n);

    }
    static void binarySearch(long start,long end){
        if(start>end) {
            System.out.print("NO");
            return;
        }

        long mid = (start+end)/2;
        long cut = n-mid;

        long cutCount = calcCount(mid,cut);

        if(cutCount < k){
            binarySearch(mid+1,end);
        }else if(cutCount > k){
            binarySearch(start,mid-1);
        }else if(cutCount == k){
            System.out.print("YES");
        }
    }

    static long calcCount(long n,long m){
        return (n+1)*(m+1);
    }
}
