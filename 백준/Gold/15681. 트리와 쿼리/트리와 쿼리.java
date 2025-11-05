

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,r,q;
    static ArrayList<ArrayList<Integer>> tree,edges;
    static int[] parent,size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        tree = new ArrayList<>();
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        makeTree(r,-1);
        countSubtreeNodes(r);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            int query = Integer.parseInt(br.readLine());

            sb.append(size[query]).append("\n");
        }

        System.out.print(sb);
    }

    public static void makeTree(int curNode,int p){

        for(int node : edges.get(curNode)){
            if(node != p){
                tree.get(curNode).add(node);
                parent[node] = curNode;
                makeTree(node,curNode);
            }
        }
    }

    public static void countSubtreeNodes(int curNode){
        size[curNode] = 1;

        for(int node : tree.get(curNode)){
            countSubtreeNodes(node);
            size[curNode] += size[node];
        }
    }
}
