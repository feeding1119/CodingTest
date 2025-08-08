

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String command = br.readLine();
        int n = command.length();
        char ec = command.charAt(n-1);

        Stack<Character> st = new Stack<>();

        for(int i=0;i<input.length();i++){
            st.push(input.charAt(i));

            if(st.size() >= command.length()){
                if(st.peek().equals(ec)){
                    if(compareChar(st,command)){
                        for(int j=0;j<n;j++) st.pop();
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<st.size();i++) sb.append(st.get(i));

        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());

    }

    public static boolean compareChar(Stack<Character> st,String command){

        int n = command.length();

        for(int i=0;i<n;i++){
            if(command.charAt(i) != st.get(st.size()-n+i)) return false;
        }

        return true;
    }
}
