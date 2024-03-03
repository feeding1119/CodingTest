

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T,n,d;

    static int[][] XArr;
    static int[][] XArrCopy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            XArr = new int[n][n];
            XArrCopy = new int [n][n];

            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++){
                    XArr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if(d>0){
                rotateClockwise(d/45);
            }else if(d<0){
                rotateCounterclockwise(Math.abs(d)/45);
            }
            printArr();

        }
    }

    static void rotateClockwise(int count){
        for(int i=0;i<count;i++){
            int mid = n/2;
            int arrSize = n;

            for(int j=0;j<mid;j++){
                copyArr();
                int diff = arrSize/2;

                XArr[j][j] = XArrCopy[j+diff][j];
                XArr[j+diff][j] = XArrCopy[j+2*diff][j];
                XArr[j+2*diff][j] = XArrCopy[j+2*diff][j+diff];
                XArr[j+2*diff][j+diff] = XArrCopy[j+2*diff][j+2*diff];
                XArr[j+2*diff][j+2*diff] = XArrCopy[j+diff][j+2*diff];
                XArr[j+diff][j+2*diff] = XArrCopy[j][j+2*diff];
                XArr[j][j+2*diff] = XArrCopy[j][j+diff];
                XArr[j][j+diff] = XArrCopy[j][j];


                arrSize -= 2;
            }


        }
    }

    static void rotateCounterclockwise(int count){
        for(int i=0;i<count;i++){
            int mid = n/2;
            int arrSize = n;

            for(int j=0;j<mid;j++){
                copyArr();
                int diff = arrSize/2;

                XArr[j][j] = XArrCopy[j][j+diff];
                XArr[j][j+diff] = XArrCopy[j][j+2*diff];
                XArr[j][j+2*diff] = XArrCopy[j+diff][j+2*diff];
                XArr[j+diff][j+2*diff] = XArrCopy[j+2*diff][j+2*diff];
                XArr[j+2*diff][j+2*diff] = XArrCopy[j+2*diff][j+diff];
                XArr[j+2*diff][j+diff] = XArrCopy[j+2*diff][j];
                XArr[j+2*diff][j] = XArrCopy[j+diff][j];
                XArr[j+diff][j] = XArrCopy[j][j];


                arrSize -= 2;
            }


        }
    }

    static void printArr(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(XArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void printCopyArr(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(XArrCopy[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void copyArr(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                XArrCopy[i][j] = XArr[i][j];
            }
        }
    }
}
