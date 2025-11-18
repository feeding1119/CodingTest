
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> ls = new ArrayList<>();

        ls.add(arr[0]);

        for(int i=1;i<n;i++){

            int key = arr[i];

            if(ls.get(ls.size()-1) < key){
                ls.add(key);
            }else{
                int s = 0;
                int e = ls.size()-1;

                while(s<e){
                    int mid = (s+e)/2;

                    if(ls.get(mid) < key){
                        s = mid+1;
                    }else{
                        e = mid;
                    }
                }

                ls.set(s,key);
            }


        }

        System.out.println(ls.size());
    }

}
