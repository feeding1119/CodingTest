

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int L,C;
    static String[] code;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        code = new String[C];
        isUsed = new boolean[C];

        for(int i=0;i<C;i++){
            code[i] = st.nextToken();
        }

        Arrays.sort(code);

        dfs("",0);

    }

    private static void dfs(String word,int index){
        if(word.length() == L){
            if(checkOne(word) && checkTwo(word)) System.out.println(word);
            return;
        }

        if(index >= C) return;

        dfs(word+code[index],index+1);
        dfs(word,index+1);
    }

    private static boolean checkOne(String word){
        for(int i=0;i<word.length();i++){
            char temp = word.charAt(i);
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'u' || temp == 'o' ) return true;
        }

        return false;
    }

    private static boolean checkTwo(String word){
        int count = 0;
        for(int i=0;i<word.length();i++){
            char temp = word.charAt(i);
            if(temp != 'a' && temp != 'e' && temp != 'i' && temp != 'u' && temp != 'o' ) count++;

            if(count >= 2) return true;
        }

        return false;
    }

}
