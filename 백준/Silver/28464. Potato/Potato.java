
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] potatoes = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            potatoes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(potatoes);

        int temp = 0;

        for(int i=0;i<n/2;i++){
            temp += potatoes[i];
        }

        System.out.print(temp+" ");

        temp = 0;

        for(int i=n/2;i<n;i++){
            temp += potatoes[i];
        }

        System.out.print(temp);
    }
}
