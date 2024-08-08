import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int answer = 0 ;
        for(int i=0;i<N;i++){
            q.offer(Integer.parseInt(br.readLine()));
        }
        while(q.size() > 1){
            int A = q.poll();
            int B = q.poll();

            answer += A+B;
            q.offer(A+B);
        }

        System.out.println(answer);
    }
}