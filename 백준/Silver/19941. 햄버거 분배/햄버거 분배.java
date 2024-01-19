import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String hp = br.readLine();

        Character[] hpList = new Character[N];

        for(int i=0;i<N;i++){
            hpList[i] = hp.charAt(i);
        }

        int totalCount = 0;

        for(int i=0;i<N;i++){
            if(hpList[i].equals('H')){
                int index = i-K;
                while(index <= i+K){
                    if(index < 0){
                       index++;
                       continue;
                    }

                    if(index >= N){
                        break;
                    }
                    if(hpList[index].equals('P')){
                        hpList[index] = 'N';
                        totalCount++;
                        break;
                    }
                    index++;
                }
            }
        }

        System.out.println(totalCount);



    }
}
