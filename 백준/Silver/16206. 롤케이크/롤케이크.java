
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        List<Integer> cake = new ArrayList<>();
        List<Integer> firstCake = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp == 10){
                answer++;
            }else if(temp > 10){
                if(temp%10==0) firstCake.add(temp);
                else cake.add(temp);
            }
        }

        Collections.sort(firstCake);

        int cut = 0;

        for(int c : firstCake){
            int temp = c/10;

            if(M-cut >= temp-1){
                answer += temp;
                cut += temp-1;
            }else{
                answer += M-cut;
                cut += M-cut;
                break;
            }
        }

        if(cut != M){
            for(int c: cake){
                int temp = c/10;

                if(M-cut>=temp){
                    answer+=temp;
                    cut += temp;
                }else{
                    answer += M-cut;
                    break;
                }

            }
        }

        System.out.println(answer);
    }
}
