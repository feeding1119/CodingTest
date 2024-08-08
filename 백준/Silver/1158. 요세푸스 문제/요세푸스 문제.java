import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++){
            q.offer(i);
        }

        int index = 1;
        int size = 0;
        System.out.print("<");
        while(!q.isEmpty()){
            int temp = q.poll();

            if(index%K != 0) q.offer(temp);
            else {
                size++;
                if(N != size){
                    System.out.print(temp+", ");

                }else{
                    System.out.print(temp);
                }

            }
            index++;
        }
        System.out.print(">");
    }
}