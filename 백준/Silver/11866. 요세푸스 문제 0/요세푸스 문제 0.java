

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            q.offer(i);
        }

        System.out.print("<");
        for(int i=0;i<n;i++){
            int count = 0;
            while(!q.isEmpty()){
                int temp = q.poll();
                count++;

                if(count == k){
                    System.out.print(temp);
                    break;
                }

                q.offer(temp);
            }

            if(i!=n-1) System.out.print(", ");

        }
        System.out.print(">");
    }
}
