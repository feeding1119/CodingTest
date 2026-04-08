
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static int[] belt,box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2*n];
        box = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < 2*n;i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while(true){
            answer++;
            spinAll();
            moveBox();
            addBox();
            if(checkAnser()) break;
        }

        System.out.println(answer);
    }

    public static void spinAll(){
        spinBelt();
        spinBox();
    }

    public static void spinBelt(){

        int temp = belt[2*n-1];

        for(int i=2*n-1;i>0;i--){
            belt[i] = belt[i-1];
        }

        belt[0] = temp;
    }

    public static void spinBox(){
        for(int i=n-1;i>0;i--){
            box[i] = box[i-1];
        }

        box[0] = 0;
    }

    public static void moveBox(){

        removeBox();

        for(int i=n-2;i>=0;i--){
            if(box[i] == 1 && box[i+1] == 0 && belt[i+1] >= 1){
                box[i+1] = 1;
                box[i] = 0;
                belt[i+1]--;
                removeBox();
            }

        }
    }

    public static void addBox(){
        if(belt[0] >= 1) {
            box[0] = 1;
            belt[0]--;
        }
    }

    public static void removeBox(){
        if(box[n-1] == 1) box[n-1] = 0;
    }

    public static boolean checkAnser(){
        int count = 0;

        for(int i=0;i<2*n;i++){
            if(belt[i] == 0) count++;
        }

        if(count >= k) return true;

        return false;
    }

    public static void printNow(){
        System.out.print("belt : ");
        for(int i=0;i<2*n;i++){
            System.out.print(belt[i]+" ");
        }

        System.out.println();

        System.out.print("box : ");
        for(int i=0;i<2;i++){
            System.out.print(box[i]+" ");
        }

        System.out.println();
        System.out.println();
    }
}
