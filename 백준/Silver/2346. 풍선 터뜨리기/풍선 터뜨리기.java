import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[N];
        for(int i=0;i<N;i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1;i<=N;i++){
            dq.offer(i);
        }

        while(true){
            int index = dq.poll();
            int temp = count[index-1];

            System.out.print(index+" ");
            if(dq.size() == 0) break;
            if(temp > 0){
                for(int i=1;i<temp;i++){
                    dq.offerLast(dq.pollFirst());
                }
            }else if (temp < 0){
                temp = Math.abs(temp);
                for(int i=0;i<temp;i++){
                    dq.offerFirst(dq.pollLast());
                }
            }
        }
    }
}