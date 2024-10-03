
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,S,E;
    static List<Integer>[] map;

    static String goRoute = "";
    static List<List<Integer>> ans = new ArrayList<>();
    static int dis = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new List[N+1];

        for(int i=0;i<=N;i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }
        
        for(int i=0;i<=N;i++){
            Collections.sort(map[i]);
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dis += bfs(S,E);

        for(String s : goRoute.split(" ")){
            int temp = Integer.parseInt(s);
            if(temp != S && temp != E) map[temp] = new ArrayList<>();
        }

        dis += bfs(E,S);
        System.out.println(dis);
    }

    private static int bfs(int start,int end){
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{String.valueOf(start),String.valueOf(0),String.valueOf(start)});

        boolean[] v = new boolean[N+1];

        while(!q.isEmpty()){
            String[] temp = q.poll();
            int index = Integer.parseInt(temp[0]);
            int count = Integer.parseInt(temp[1]);
            String route = temp[2];

            if(index == end) {
                goRoute = route;
                return count;
            }

            for(int i=0;i<map[index].size();i++){
                int pos = map[index].get(i);
                if(!v[pos]){
                    v[pos] = true;
                    q.offer(new String[]{String.valueOf(pos),String.valueOf(count+1),route+" "+pos});
                }
            }
        }

        return -1;
    }
}
