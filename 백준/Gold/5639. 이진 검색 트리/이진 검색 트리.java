import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String input = br.readLine();

            if(input == null ||input.equals("")) break;

            int n = Integer.parseInt(input);
            root.insert(n);
        }

        postOrder(root);
    }

    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.v);

    }

    static class Node{
        int v;
        Node left,right;

        Node(int v){
            this.v = v;
        }

        Node(int v,Node left,Node right){
            this.v = v;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n<this.v){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }else{
                if(this.right==null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
}
