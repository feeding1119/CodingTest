

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static boolean[][] map;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new boolean[n+1][n+1];
        parent = new int[n+1];

        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<n+1;j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    if(parent[i] != parent[j]) union(i,j);
                }
            }
        }

        boolean answer = true;

        st = new StringTokenizer(br.readLine());
        int temp = parent[Integer.parseInt(st.nextToken())];
        for(int i=1;i<m;i++){
            if(temp != parent[Integer.parseInt(st.nextToken())]){
                answer = false;
                break;
            }
        }

        if(answer) System.out.println("YES");
        else System.out.println("NO");



    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x>y) parent[x] = y;
        else parent[y] = x;
    }
}
