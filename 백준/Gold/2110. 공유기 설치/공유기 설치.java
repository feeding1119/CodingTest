import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,C;
    static int[] house;

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int i=0;i<N;i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        binarySearch(1,house[N-1]-house[0]);
        System.out.println(answer);
    }

    static void binarySearch(int start,int end){
        if(start>end) return;

        int mid = (start+end)/2;

        int count = 1;
        int left = house[0];
        for(int i=1;i<N;i++){
            if(house[i] - left >= mid){
                count++;
                left = house[i];
            }
        }

        if(count >= C){
            answer = Math.max(answer,mid);
            binarySearch(mid+1, end);
        }else{
            binarySearch(start,mid-1);
        }

    }
}
