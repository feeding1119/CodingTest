import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int FIVE_COIN = 5;
    static final int TWO_COIN = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int totalCount = 0;

        if(n>=FIVE_COIN){
            if(isEven(n%FIVE_COIN)){
                totalCount += n/FIVE_COIN + n%FIVE_COIN/TWO_COIN;
            }else{
                totalCount += ((n/FIVE_COIN)-1)+(((n%FIVE_COIN)+FIVE_COIN)/TWO_COIN);
            }
        }else{
            if(isEven(n)){
                totalCount = n/TWO_COIN;
            }else{
                totalCount = -1;
            }
        }


        System.out.println(totalCount);
    }

    public static boolean isEven(int num){
        if(num%2==0){
            return true;
        }else{
            return false;
        }
    }

}