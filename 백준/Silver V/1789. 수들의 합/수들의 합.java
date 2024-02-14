import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long N;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        binarySearch(1,N);
        System.out.println(result);

    }

    static long calculateSum(long x){
        return (x*(x+1))/2;
    }

    static void binarySearch(long start, long end){
        if(start>end) return;

        long mid = (start+end)/2;
        long sum = calculateSum(mid);
        if(sum>N){
            binarySearch(start,mid-1);
        }else if(sum < N){
            result = mid;
            binarySearch(mid+1,end);
        }else{
            result = mid;
        }
    }

}
