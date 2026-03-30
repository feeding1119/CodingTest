import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }

            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                int a = maxHeap.poll();
                int b = minHeap.poll();

                maxHeap.add(b);
                minHeap.add(a);
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);

    }
}
