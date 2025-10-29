import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int now = n-1;
        int count = 1;
        int max = 1;

        sb.append("U 1 -1").append("\n");

        for(int i=0;i<m;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp != now){
                sb.append("U "+(temp+1)+" "+max++ ).append("\n");
                now = temp;
                count++;
            }

            sb.append("P").append("\n");
            count++;
        }

        System.out.println(count);
        System.out.print(sb);
    }
}
