import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n-1];

            dfs(0);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int index){

        if(index == n-1){
            if(isZero()) sb.append(arrToString()).append("\n");
            return;
        }

        for(int i=0;i<3;i++){
            arr[index] = i;
            dfs(index+1);
        }

    }
    public static boolean isZero(){
        String temp = "1";

        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> sign = new ArrayList<>();

        for(int i=1;i<n;i++){
            if(arr[i-1] == 0){
                temp += i+1;
            }else{
                num.add(Integer.parseInt(temp));
                sign.add(arr[i-1]);
                temp = String.valueOf(i+1);
            }
        }
        num.add(Integer.parseInt(temp));

        int total = num.get(0);

        for(int i=1;i<num.size();i++){
            int s = sign.get(i-1);

            if(s == 1){
                total += num.get(i);
            }else if(s == 2){
                total -= num.get(i);
            }
        }

        if(total == 0) return true;
        return false;

    }

    public static String arrToString(){
        String result = "1";

        for(int i=0;i<n-1;i++){
            if(arr[i] == 0) result += " ";
            if(arr[i] == 1) result += "+";
            if(arr[i] == 2) result += "-";

            result+=i+2;
        }
        return result;
    }
}
