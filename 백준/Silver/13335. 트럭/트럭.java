

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new LinkedList<>();

        for(int i=0;i<w;i++){
            q.offer(0);
        }

        int[] truck = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int curWeight = 0;
        int idx = 0;
        while(idx < n){
            curWeight -= q.pollFirst();
            if(curWeight + truck[idx] <= L){
                curWeight += truck[idx];
                q.offer(truck[idx]);
                idx++;
            }else{
                q.offer(0);
            }
            
            time++;
        }

        System.out.println(time+w);
    }
}
