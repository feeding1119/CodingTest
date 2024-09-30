
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[1] == o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[1] == o2[1]) return o2[0]-o1[0];
                return o2[1]-o1[1];
            }
        });

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map.put(P,L);
            minHeap.offer(new int[]{P,L});
            maxHeap.offer(new int[]{P,L});
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                map.put(P,L);
                minHeap.offer(new int[]{P,L});
                maxHeap.offer(new int[]{P,L});
            }else if(command.equals("recommend")){
                int level = Integer.parseInt(st.nextToken());

                if(level == 1){
                    int[] temp = maxHeap.peek();

                    while(true){
                        if(map.containsKey(temp[0]) && map.get(temp[0]) == temp[1]) break;

                        maxHeap.poll();
                        temp = maxHeap.peek();
                    }

                    System.out.println(temp[0]);
                }else if(level == -1){
                    int[] temp = minHeap.peek();

                    while(true){
                        if(map.containsKey(temp[0]) && map.get(temp[0]) == temp[1]) break;

                        minHeap.poll();
                        temp = minHeap.peek();
                    }
                    System.out.println(temp[0]);
                }
            }else if(command.equals("solved")){
                int num = Integer.parseInt(st.nextToken());

                map.remove(num);
            }
        }


    }
}
