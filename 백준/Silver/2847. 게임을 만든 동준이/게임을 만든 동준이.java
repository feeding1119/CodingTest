import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] level = new int[N];

        for(int i=0;i<N;i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=N-1;i>0;i--){
            while(true){
                if(level[i-1] < level[i]){
                    break;
                }

                level[i-1] = level[i-1]-1;
                count++;
            }
        }

        System.out.println(count);
    }
}
