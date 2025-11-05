

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> st = new Stack<>();


        int[] priority = new int[50];

        priority['*'] = 1;
        priority['/'] = 1;
        priority['('] = -1;
        priority[')'] = -1;

        String answer = "";

        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);

            if(temp >= 'A'){ //문자일 경우 바로 적기
                answer += temp;
                continue;
            }

            if(temp == '('){ //괄호일 경우 스택에 바로 넣기
                st.push(temp);
                continue;
            }

            if(temp == ')'){ //닫는 괄호일 경우
                while(st.peek() != '('){ //짝에 맞는 괄호가 나올때까지 적기
                    answer += st.pop();
                }
                st.pop(); // '(' 빼주기
                continue;
            }

            while(!st.isEmpty() && priority[st.peek()] >= priority[temp]){ // 연산자 우선순위 비교하면서 계속 적기
                answer += st.pop();
            }

            st.push(temp);
        }

        while(!st.empty()){ //스택에 남은거 털어주기
            answer += st.pop();
        }

        System.out.println(answer);
    }
}
