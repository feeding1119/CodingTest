

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static List<Integer> truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        truth = new ArrayList<>();
        List<List<Integer>> party = new ArrayList<>();

        int answer = 0;

        for(int i=0;i<=m;i++){
            party.add(new ArrayList<>());
        }

        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if(k == 0){
            System.out.println(m);
            return;
        }

        for(int i=0;i<k;i++){
            truth.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());

            party.get(i).add(first);

            for(int j=1;j<p;j++){
                int next = Integer.parseInt(st.nextToken());

                union(first,next);

                party.get(i).add(next);
            }
        }

        for(int i=1;i<=m;i++){
            boolean check = true;

            for(int person : party.get(i)){
                if(truth.contains(find(parent[person]))){
                    check = false;
                    break;
                }
            }

            if(check) answer++;
        }

        System.out.println(answer);



    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

    public static void union(int x,int y){
        int px = find(x);
        int py = find(y);

        if(truth.contains(py)){
            int temp = px;
            px = py;
            py = temp;
        }

        parent[py] = px;
    }

}
