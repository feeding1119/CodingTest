
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,s;
    static int[] Ai;
    static boolean[] vistied;
    static int[] dx = {-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Ai = new int[n];
        vistied = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());

        dfs(s-1);

        int answer=0;
        for(int i=0;i<n;i++){
            if(vistied[i]) answer++;
        }

        System.out.println(answer);


    }

    static void dfs(int index){
        vistied[index] = true;

        for(int i=0;i<2;i++){
            int x = index + dx[i]*Ai[index];

            if(x>=0 && x<n && !vistied[x]) dfs(x);
        }
    }
}
