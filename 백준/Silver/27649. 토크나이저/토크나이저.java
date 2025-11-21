import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Set<Character> set = new HashSet<>();
        List<String> answer = new ArrayList<>();

        set.add('<');
        set.add('>');
        set.add('&');
        set.add('|');
        set.add('(');
        set.add(')');
        set.add(' ');

        String prev = "";

        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            String str = "";

            if(set.contains(temp)){
                if(!prev.equals("")){
                    answer.add(prev);
                    prev = "";
                }

                if(temp == ' ') continue;

                str += temp;
                if(temp == '&' || temp == '|'){
                    str += temp;
                    i++;
                }
                answer.add(str);
            }else{
                prev += temp;
            }
        }

        if(prev.length() !=0) answer.add(prev);
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : answer){
            sb.append(s).append(" ");
        }
        
        System.out.print(sb);




    }
}
