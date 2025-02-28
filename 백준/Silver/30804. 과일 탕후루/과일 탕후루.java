import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fruit = new int[n];

        for(int i=0;i<n;i++){
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;

        int start = 0;
        int end = 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(fruit[0],1);
        while(true){
            if(map.size() <= 2){
                int temp = end - start + 1;
                if(temp > answer) answer = temp;

                end++;
                if(end == n) break;
                if(map.containsKey(fruit[end])){
                    map.put(fruit[end],map.get(fruit[end])+1);
                }else{
                    map.put(fruit[end],1);
                }
            }else{
                if(map.get(fruit[start])-1 == 0){
                    map.remove(fruit[start]);
                }else{
                    map.put(fruit[start],map.get(fruit[start])-1);
                }

                start++;
            }
        }

        System.out.println(answer);
    }
}
