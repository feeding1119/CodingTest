import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;

        boolean checkPossibility = false;

        while(A<=B){
            if(A==B){
                checkPossibility = true;
                break;
            }

            if(isEven(B)){
                B /= 2;
            }else{
                if(B%10 == 1){
                    B /= 10;
                }else{
                    break;
                }
            }
            count += 1;


        }

        if(checkPossibility){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    }
}
