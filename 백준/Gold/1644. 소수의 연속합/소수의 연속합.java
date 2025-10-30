import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static ArrayList<Integer> pm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        pm = new ArrayList<>();
        
        if(n==1){
            System.out.println(0);
            return;
        }

        for(int i=2;i<=n;i++){
            if(isPrime(i)) pm.add(i);
        }


        int answer = 0;
        int total = 2;
        int left = 0;
        int right = 0;

        while(left <= right){

            // System.out.println("left:"+left +", right:"+ right +" => "+ total);
            if(total >= n){
                if(total == n)answer++;
                total -= pm.get(left++);
            }else{
                if(right == pm.size()-1) break;
                total += pm.get(++right);
            }
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int n){

        int m = (int)Math.sqrt(n);

        for(int i=2;i<=m;i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
