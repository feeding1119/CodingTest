
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Gem implements Comparable<Gem>{
        int m,v;

        public Gem(int m,int v){
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Gem o){
            return this.m-o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Gem[] gems = new Gem[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(m,v);
        }

        int[] bags = new int[k];


        for(int i=0;i<k;i++){
            int c = Integer.parseInt(br.readLine());

            bags[i] = c;
        }

        Arrays.sort(bags);
        Arrays.sort(gems);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int idx = 0;

        for(int bag:bags){
            while(idx < n && gems[idx].m <= bag){
                pq.offer(gems[idx].v);
                idx++;
            }

            if(!pq.isEmpty()){
                answer+= pq.poll();
            }
        }
        
        System.out.println(answer);

    }
}
