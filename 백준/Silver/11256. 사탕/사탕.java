import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;



        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            List<Integer> boxes = new ArrayList<>();

            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                boxes.add(a*b);
            }

            int total=0;
            int count=1;
            Collections.sort(boxes,Collections.reverseOrder());

            for(int box : boxes){
                total += box;
                if(total >= J ) {
                    break;
                }
                count++;
            }

            System.out.println(count);
        }
    }
}
