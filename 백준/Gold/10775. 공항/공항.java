

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for(int i=1;i<G+1;i++){
            parent[i] = i;
        }

        int P = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0;i<P;i++){
            int g = Integer.parseInt(br.readLine());

            int temp = find(g);

            if(temp == 0) break;

            answer++;
            union(temp,temp-1);

        }

        System.out.println(answer);
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        y = find(y);

        parent[x] = y;

    }


}
