
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for(int i=n;i>0;i--){
            if(i%2 == 0) dq.addLast(i);
            else dq.addFirst(i);
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
