import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] myCard;
    static int M;
    static int[] yourCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        myCard = new int[N];

        for(int i=0;i<N;i++){
            myCard[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        yourCard = new int[M];

        for(int i=0;i<M;i++){
            yourCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCard);

        for(int i=0;i<M;i++){
            binarySeach(0,N-1,yourCard[i]);
        }

    }

    static void binarySeach(int start,int end, int n){
        if(start > end){
            System.out.print("0 ");
            return;
        }

        int mid = (start+end)/2;

        if(myCard[mid] == n){
            System.out.print("1 ");
        }else if(myCard[mid] < n){
            binarySeach(mid+1,end,n);
        }else if(myCard[mid] > n){
            binarySeach(start,mid-1,n);
        }
    }
}
