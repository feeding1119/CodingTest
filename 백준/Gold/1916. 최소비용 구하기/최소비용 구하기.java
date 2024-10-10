

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    class Node implements Comparable<Node>{
        int end;
        int cost;

        Node(int end, int cost){
            this.end  = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public class Main {

        static int N,M;
        static List<List<Node>> bus = new ArrayList<>();
        static boolean[] v;
        static int[] dist;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            v= new boolean[N+1];
            dist = new int[N+1];

            for(int i=0;i<=N;i++){
                bus.add(new ArrayList<>());
            }

            StringTokenizer st;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                bus.get(A).add(new Node(B,cost));
            }

            Arrays.fill(dist,Integer.MAX_VALUE);

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(start,0));
            dist[start] = 0;

            while(!pq.isEmpty()){
                Node curNode = pq.poll();

                if(!v[curNode.end]){
                    v[curNode.end] = true;

                    for(Node n : bus.get(curNode.end)){
                        if(!v[n.end] && dist[n.end] > dist[curNode.end] + n.cost){
                            dist[n.end] = dist[curNode.end] + n.cost;
                            pq.offer(new Node(n.end,dist[n.end]));
                        }
                    }
                }
            }

            System.out.println(dist[end]);
        }
    }
