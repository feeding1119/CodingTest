
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] count = new int[20001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(st.nextToken());

            num[i] = temp;
            count[temp+10000]++;
        }

        long answer = 0L;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int sum = num[i]+num[j];
                if(Math.abs(sum) > 10000) continue;

                answer+=count[-sum+10000];

                if(-sum == num[i]) answer--;
                if(-sum == num[j]) answer--;
            }
        }

        System.out.println(answer/3);

    }

}
