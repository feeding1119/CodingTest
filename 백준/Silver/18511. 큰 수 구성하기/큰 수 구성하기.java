import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int[] elements;
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        elements = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            elements[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(elements);
        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int num){
        if(num > N) return;

        if(answer < num) answer = num;

        for(int i=0; i<K;i++){
            dfs(10*num+elements[i]);
        }
    }
}
