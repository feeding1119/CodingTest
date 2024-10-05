import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S,T;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(answer);
    }

    private static void dfs(String value){
       if(value.length() == S.length()){
           if(value.equals(S)) answer = 1;
           return;
       }

        if(value.startsWith("B")){
            String reverse = "";
            for(int i=value.length()-1;i>0;i--){
                reverse += value.charAt(i);
            }

            dfs(reverse);
        }

        if(value.endsWith("A")){
            dfs(value.substring(0,value.length()-1));
        }
    }
}
