import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean isCheck = true;
        
        for(int i=1;i<=N;i++){
            String temp = String.valueOf(i);

            int answer = i;
            for(int j=0;j<temp.length();j++){
                answer += temp.charAt(j)-'0';
            }

            if(answer == N){
                System.out.println(i);
                isCheck = false;
                break;
            }
        }
        
        if(isCheck) System.out.println(0);
    }
}
