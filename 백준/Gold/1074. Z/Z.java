import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int size = 1;
        for(int i = 0;i<n;i++){
            size *= 2;
        }

        dfs(size,r,c);

        System.out.println(answer);
    }

    public static void dfs(int size,int r,int c){
        if(size == 1) return;

        int hSize = size/2;

        if(r < hSize && c < hSize){
            dfs(hSize,r,c);
        }else if(r < hSize && c >= hSize){
            answer +=  size*size/4;
            dfs(hSize,r,c-hSize);
        }else if(r >= hSize && c < hSize){
            answer += (size*size/4)*2;
            dfs(hSize,r-hSize,c);
        }else if(r >= hSize && c >= hSize){
            answer += (size*size/4)*3;
            dfs(hSize,r-hSize,c-hSize);
        }


    }
}
