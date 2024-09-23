
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num=1;
        int value=1;
        while(true){
            if(num > 1000) break;
            ls.add(num);
            num+= ++value;
        }

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());

            if(isCheck(temp)) System.out.println(1);
            else System.out.println(0);

        }
    }

    static private boolean isCheck(int num){
        for(int i=0;i<ls.size();i++){
            for(int j=0;j<ls.size();j++){
                for(int k=0;k<ls.size();k++){
                    if(ls.get(i)+ls.get(j)+ls.get(k) == num) return true;
                }
            }
        }

        return false;
    }
}
