
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] num = new int[s];

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<s;j++){
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);

            int start = 0;
            int end = s-1;

            int minValue = Integer.MAX_VALUE;

            int count = 0;

            while(start < end){
                int temp = num[start] + num[end];
                int diff = temp-k;


                if(minValue == Math.abs(diff)){
                    count++;
                }else if(minValue > Math.abs(diff)){
                    minValue = Math.abs(diff);
                    count = 1;

                }

                if(diff <= 0){
                    start++;
                }else{
                    end--;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
