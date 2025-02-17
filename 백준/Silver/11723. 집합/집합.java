
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();


        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("all")) {
                for(int j=1;j<=20;j++){
                    set.add(j);
                }
                continue;
            }

            if(command.equals("empty")){
                set.clear();
                continue;
            }

            int n = Integer.parseInt(st.nextToken());

            if(command.equals("add")) set.add(n);

            if(command.equals("remove")) set.remove(n);

            if(command.equals("check")){
                if(set.contains(n)) sb.append("1\n");
                else sb.append("0\n");
            }

            if(command.equals("toggle")){
                if(set.contains(n)) set.remove(n);
                else set.add(n);
            }
        }

        System.out.println(sb);
    }
}
