

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] initNum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            set.add(temp);
            initNum[i] = temp;
        }

        Integer[] num = set.toArray(new Integer[0]);

        Arrays.sort(num);

        map.put(num[0],0);

        for(int i=1;i<num.length;i++){
            if(num[i] == num[i-1]) continue;
            map.put(num[i],i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(map.get(initNum[i])+" ");
        }

        System.out.println(sb);
    }
}
