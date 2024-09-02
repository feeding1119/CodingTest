
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String[] arr;
    static String maxNum = "-1";
    static String minNum = "10000000000";
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        isUsed = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = st.nextToken();
        }

        dfs("");

        System.out.println(maxNum);
        System.out.println(minNum);

    }

    private static void dfs(String num){
        if(num.length() == N+1){
            if(isCorrect(num)){
                if(Long.parseLong(maxNum) < Long.parseLong(num)) maxNum = num;
                if(Long.parseLong(minNum) > Long.parseLong(num)) minNum = num;
            }
            return;
        }

        for(int i=0;i<10;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                dfs(num+i);
                isUsed[i] = false;
            }
        }
    }

    private static boolean isCorrect(String num){
        for(int i=0;i<N;i++){
            if(arr[i].equals("<")){
                if(num.charAt(i) > num.charAt(i+1)) return false;
            }else{
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }

        return true;
    }
}
