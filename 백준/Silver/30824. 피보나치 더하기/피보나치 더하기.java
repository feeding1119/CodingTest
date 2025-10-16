import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long k,x;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            k = Long.parseLong(st.nextToken());
            x = Long.parseLong(st.nextToken());

            flag = false;
            dfs(0L,1L,1L,0);

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void dfs(long total,long prev,long now,int count){
        if(total == x && count == k) {
            flag = true;
            return;
        }

        if(total > x || count == k || now > x) return;


        dfs(total+now,prev,now,count+1);
        dfs(total,now,prev+now,count);
    }
}
