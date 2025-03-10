import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String input = br.readLine();

            int n = Integer.parseInt(br.readLine());

            String arrTemp = br.readLine();

            String[] arr = arrTemp.substring(1,arrTemp.length()-1).split(",");

            Deque<Integer> dq = new ArrayDeque<>();

            for(int j=0;j<n;j++){
                dq.offer(Integer.parseInt(arr[j]));
            }

            boolean reverse = false;
            boolean err = false;

            for(int j=0;j<input.length();j++){
                if(input.charAt(j) == 'R') reverse = !reverse;

                if(input.charAt(j) == 'D'){
                    if(dq.isEmpty()){
                        err = true;
                        break;
                    }

                    if(reverse) dq.pollLast();
                    else dq.poll();
                }

            }


            StringBuilder sb = new StringBuilder();

            if(err) sb.append("error");
            else{
                int temp = dq.size();
                sb.append("[");
                for(int j=0;j<temp;j++){
                    if(reverse) sb.append(dq.pollLast());
                    else sb.append(dq.poll());

                    if(j != temp-1) sb.append(",");
                }
                sb.append("]");
            }

            System.out.println(sb);
        }
    }
}
