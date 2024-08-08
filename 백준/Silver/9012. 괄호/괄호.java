import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            Stack<Character> stack = new Stack<>();

            String input = br.readLine();
            Boolean isVPS = true;
            for(int j=0;j<input.length();j++){
                Character temp = input.charAt(j);

                if(temp == '(') stack.push('(');
                else{
                    if(stack.isEmpty()){
                        isVPS = false;
                        break;
                    }else stack.pop();
                }

            }

            if(isVPS && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }


    }
}