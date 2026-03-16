import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] title = new String[n];
        int[] power = new int[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            int target = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n-1;

            while(left <= right){
                int mid = (left + right) / 2;

                if (power[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(title[left]).append("\n");
        }

        System.out.println(sb);
    }
}
