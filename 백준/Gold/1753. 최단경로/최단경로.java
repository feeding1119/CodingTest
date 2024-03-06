import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end,weight;

    public Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n){
        return weight - n.weight;
    }
}

public class Main {
    static int V,E,startNode;
    static int[] minDistance;
    static List<Node>[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(br.readLine());

        distances = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            distances[i] = new ArrayList<>();
        }

        minDistance = new int[V+1];
        Arrays.fill(minDistance,Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            distances[start].add(new Node(end,weight));
        }

        dijkstra(startNode);

        for(int i=1;i<=V;i++){
            if (minDistance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else{
                System.out.println(minDistance[i]);
            }
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        q.add(new Node(start,0));
        minDistance[start] = 0;

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            int num = currentNode.end;

            if(visited[num]) continue;
            visited[num] = true;

            for(Node node : distances[num]){
                if(minDistance[node.end] > minDistance[num] + node.weight){
                    minDistance[node.end] = minDistance[num] + node.weight;
                    q.add(new Node(node.end, minDistance[node.end]));
                }
            }
        }
    }
}
