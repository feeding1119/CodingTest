import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cards = new PriorityQueue<>();

        int result = 0;
        for(int i=0;i<N;i++){
            cards.offer(Integer.parseInt(br.readLine()));
        }

        while(cards.size()!=1) {
            int a = cards.poll();
            int b = cards.poll();

            int n = a+b;
            result += n;

            cards.offer(n);
        }

        System.out.println(result);

    }
}
