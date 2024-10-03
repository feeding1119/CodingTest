import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] stu;
    static boolean[] v,check;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());

            st= new StringTokenizer(br.readLine());

            stu = new int[n+1];
            check = new boolean[n+1];
            v = new boolean[n+1];

            for(int j=1;j<=n;j++){
                stu[j] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            for(int j=1;j<=n;j++){
                if(!check[j]){
                    dfs(j);
                }

            }

            System.out.println(n-count);
        }

    }

    static private void dfs(int a){

        if(v[a]){
            check[a] = true;
            count++;
        }else v[a] = true;

        if(!check[stu[a]]) dfs(stu[a]);

        v[a] = false;
        check[a] = true;
    }
}
