

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] v;
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][2];
        v= new boolean[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0)-'A';
            graph[index][0] = st.nextToken().charAt(0);
            graph[index][1] = st.nextToken().charAt(0);
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);

    }

    private static void preorder(int start){
        char temp =  (char)('A'+start);
        System.out.print(temp);

        if(graph[start][0] != '.'){
            preorder(graph[start][0]-'A');
        }

        if(graph[start][1] != '.'){
            preorder(graph[start][1]-'A');
        }
    }

    private static void inorder(int start){
        if(graph[start][0] != '.'){
            inorder(graph[start][0]-'A');
        }

        char temp =  (char)('A'+start);
        System.out.print(temp);

        if(graph[start][1] != '.'){
            inorder(graph[start][1]-'A');
        }
    }

    private static void postorder(int start){
        if(graph[start][0] != '.'){
            postorder(graph[start][0]-'A');
        }

        if(graph[start][1] != '.'){
            postorder(graph[start][1]-'A');
        }

        char temp =  (char)('A'+start);
        System.out.print(temp);
    }
}
