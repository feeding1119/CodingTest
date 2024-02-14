import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] Narr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Narr =new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Narr);

        M = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            binarySearch(0,N-1,Integer.parseInt(st.nextToken()));
        }

    }

    static void binarySearch(int start,int end,int n){
        if(start>end) {
            System.out.println(0);
            return;
        }

        int mid = (start+end)/2;

        if(Narr[mid] < n){
            binarySearch(mid+1,end,n);
        }else if(Narr[mid] >n){
            binarySearch(start,mid-1,n);
        }else if(Narr[mid] ==n){
            System.out.println(1);
        }
    }
}
