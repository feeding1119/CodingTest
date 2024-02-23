import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main{


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
    static int n, m;
    static int[] arr, arrm;

    public static void main(String[] args) throws NumberFormatException, IOException {


        //1라인 입력
        n = Integer.parseInt(br.readLine());
        //2라인 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n]; // 배열 초기화
        // 2라인 배열 변환
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //3라인 입력
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arrm = new int[m]; // 배열 초기화
        // 4라인 배열 변환

        for(int i=0; i<m; i++) {
            arrm[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 대상 배열 정렬
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;

        for(int i=0; i<arrm.length; i++ ) {
            binarySearch(start, end, arrm[i]);
        }

        bw.close();

    }
    static void binarySearch(int start, int end, int m) throws IOException {
        if(start > end) {
            bw.write("0\n");
            return;
        }

        int mid = (start + end)/ 2;

        if( m == arr[mid]) {
            bw.write("1\n");
        }
        else if(m < arr[mid]) {
            end = mid-1;
            binarySearch(start, end, m);
        }else if(m > arr[mid]) {
            start = mid + 1;
            binarySearch(start, end, m);

        }

    }


};
