import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K,X;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] v;

    static List<Integer> answer = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            map.add(new ArrayList<>());
        }
        v = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
        }

        bfs();

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int a : answer){
                System.out.println(a);
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{X,0});
        v[X] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[1] == K) answer.add(temp[0]);

            for(int i=0;i<map.get(temp[0]).size();i++){
                if(!v[map.get(temp[0]).get(i)]){
                    v[map.get(temp[0]).get(i)] = true;
                    q.offer(new int[]{map.get(temp[0]).get(i),temp[1]+1});
                }
            }
        }

    }
}
