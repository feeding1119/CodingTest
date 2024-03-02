
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] calender = new int[367];

    static int N;

    static int result = 0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for(int j=S;j<=E;j++){
                calender[j] += 1;
            }
        }

        int maxHeight = 0;
        int connectLength = 0;
        for(int i=1;i<=366;i++){
            if(calender[i] !=0){
                if(calender[i] >maxHeight) maxHeight = calender[i];

                connectLength += 1;
            }else{
                result += maxHeight*connectLength;
                maxHeight = 0;
                connectLength = 0;
            }
        }

        System.out.println(result);
    }
}
