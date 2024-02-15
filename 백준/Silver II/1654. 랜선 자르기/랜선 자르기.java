import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int N;
    static long[] lan;

    static long maxLan = 0;

    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new long[K];

        for(int i=0;i<K;i++){
            long l = Long.parseLong(br.readLine());
            lan[i] = l;
            if(l>maxLan){
                maxLan = l;
            }
        }

        binarySearch(1,maxLan);

        System.out.println(result);


    }

    static void binarySearch(long start,long end){
        if(start>end) return;

        long mid = (start+end)/2;

        long count = cutLan(mid);

        if(count < N){
            binarySearch(start,mid-1);
        }else if(count >= N){
            result = Math.max(result,mid);
            binarySearch(mid+1,end);
        }
    }

    static long cutLan(long h){
        long total = 0;

        for(int i=0;i<K;i++){
            total+=lan[i]/h;
        }

        return total;
    }
}
