import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int countZero = 0;
    static int countOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();

        char currentNum = input.charAt(0);
        checkNum(currentNum);

        for(int i=1;i<input.length();i++){
            if(currentNum != input.charAt(i)){
                checkNum(input.charAt(i));
                currentNum = input.charAt(i);
            }
        }

        System.out.println(Math.min(countZero,countOne));
    }
    public static void checkNum(char num){
        if(num == '0'){
            countZero += 1;
        }else{
            countOne += 1;
        }
    }
}
