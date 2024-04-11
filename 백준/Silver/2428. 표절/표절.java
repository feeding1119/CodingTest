
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] file;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        file = new int[N];

        for(int i=0;i<N;i++){
            file[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(file);

        long answer = 0;
        for(int i=0;i<N;i++){
            count = i;
            binarySearh(i,N-1,i);
            answer += count-i;
        }

        System.out.println(answer);


    }

    static void binarySearh(int start,int end,int index){
        if(start>end) return;

        int mid = (start+end)/2;

        if(10*file[index]<9*file[mid]){
            binarySearh(start,mid-1,index);
        }else{
            count = mid;
            binarySearh(mid+1,end,index);
        }
    }
}
