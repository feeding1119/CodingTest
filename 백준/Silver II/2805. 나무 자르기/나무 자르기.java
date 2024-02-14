import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] tree;
    static long result;
    static long maxTree = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int t = Integer.parseInt(st.nextToken());
            tree[i] = t;
            if(t>maxTree){
                maxTree = t;
            }
        }

        binarySeacrh(1,maxTree);
        System.out.println(result);
    }

    static void binarySeacrh(long start,long end){
        if(start>end) return;

        long mid = (start+end)/2;
        long cutTreeH = cutTree(mid);

        if(cutTreeH>M){
            result = mid;
            binarySeacrh(mid+1,end);
        }else if(cutTreeH<M){
            binarySeacrh(start,mid-1);
        }else if(cutTreeH==M){
            result = mid;
        }

    }

    static long cutTree(long h){
        long myTree = 0;

        for(int i=0;i<N;i++){
            if(tree[i] > h){
                myTree += tree[i] - h;
            }
        }
        return myTree;
    }
}
