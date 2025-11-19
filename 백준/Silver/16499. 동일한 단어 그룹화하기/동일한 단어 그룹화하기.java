
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            String input = br.readLine();

            int len = input.length();

            int[] temp = new int[len];

            for(int j=0;j<len;j++){
                temp[j] = input.charAt(j)-'a';
            }

            Arrays.sort(temp);

            String val = "";

            for(int j=0;j<len;j++){
                val += temp[j];
            }

            if(!set.contains(val)) set.add(val);
        }

        System.out.println(set.size());
    }
}
