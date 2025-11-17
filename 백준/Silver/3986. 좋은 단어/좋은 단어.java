

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i=0;i<n;i++){
            String input = br.readLine();

            int m = input.length();

            Stack<Character> st = new Stack<>();
            for(int j=0;j<m;j++){
                char temp = input.charAt(j);

                if(st.isEmpty()){
                    st.push(temp);
                }else{
                    if(st.peek() == temp) st.pop();
                    else{
                        st.push(temp);
                    }
                }
            }

            if(st.size() == 0) answer++;
        }

        System.out.println(answer);
    }
}
