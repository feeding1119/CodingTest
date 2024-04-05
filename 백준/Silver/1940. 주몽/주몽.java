
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] armor = new int[N];

        for(int i=0;i<N;i++){
            armor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(armor);

        int start = 0;
        int end = N-1;

        int count = 0;

        while(start<end){
            int temp = armor[start] + armor[end];

            if(temp==M){
                count++;
                start++;
                end--;
            }else if(temp>M){
                end--;
            }else if(temp<M){
                start++;
            }
        }

        System.out.println(count);
    }
}
