import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());

            Map<String,Integer> map = new HashMap<>();

            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                if(map.containsKey(type)) map.put(type,map.get(type)+1);
                else map.put(type,1);
            }

            int count = 1;
            for(String temp : map.keySet()) {
                count *= (map.get(temp)+1);
            }

            System.out.println(count - 1);

        }
    }
}
