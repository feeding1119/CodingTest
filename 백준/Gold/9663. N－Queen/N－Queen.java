
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int d){
        if(d == n){
            answer++;
            return;
        }

        for(int i=0;i<n;i++){
            arr[d] = i;
            if(possible(d)) dfs(d+1);
        }
    }

    public static boolean possible(int d){
        for(int i=0;i<d;i++){
            if(arr[i] == arr[d]) return false;

            if(Math.abs(d-i) == Math.abs(arr[d]-arr[i])) return false;
        }

        return true;
    }
}
