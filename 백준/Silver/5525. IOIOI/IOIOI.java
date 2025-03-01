import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int count = 0;
        int answer = 0;

        for(int i=1;i<m-1;i++){
            if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I'){
                count++;
                if(count == n){
                    if(s.charAt(i-(2*count-1)) == 'I') answer++;
                    count--;
                }

                i++;
            }else{
                count = 0;
            }
        }

        System.out.println(answer);
    }

}
