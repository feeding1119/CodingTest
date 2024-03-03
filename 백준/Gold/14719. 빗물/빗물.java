

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H,W;
    static int[] wArr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        wArr = new int[W];

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++){
            wArr[i] = Integer.parseInt(st.nextToken());
        }

        int leftWall = wArr[0];
        int leftIndex = 0;

        int temp=0;

        for(int i=1;i<W;i++){
            if(wArr[i] >= leftWall){
                leftWall = wArr[i];
                leftIndex = i;
                answer += temp;
                temp = 0;
            }else{
                if(i==W-1){
                    int rightWall = wArr[W-1];

                    temp = 0;
                    for(int j=W-1;j>=leftIndex;j--){
                        if(wArr[j] >= rightWall){
                            rightWall = wArr[j];
                            answer += temp;
                            temp = 0;
                        }else{
                            temp+=rightWall-wArr[j];
                        }
                    }
                }else{
                    temp+= leftWall - wArr[i];
                }

            }
        }

        System.out.println(answer);
    }
}
