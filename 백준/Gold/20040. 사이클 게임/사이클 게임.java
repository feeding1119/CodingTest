

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int answer = 0;

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                answer = i;
                break;
            }

            union(a,b);

        }

        System.out.println(answer);
    }

    public static int find(int x){
        if(x == parent[x]) return parent[x];
        return parent[x] = find(parent[x]);
    }

    public static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
