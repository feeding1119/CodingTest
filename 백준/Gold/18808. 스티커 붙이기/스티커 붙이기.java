import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,k;
    static boolean[][] notebook;
    static boolean[][] sticker;
    static int r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        notebook = new boolean[n][m];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            sticker = new boolean[r][c];

            for(int p=0;p<r;p++){
                st = new StringTokenizer(br.readLine());
                for(int q=0;q<c;q++){
                    if(Integer.parseInt(st.nextToken()) == 1) sticker[p][q] = true;
                }
            }
            checkSticker();

        }

        int answer = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(notebook[i][j]) {
                    //System.out.print(1+" ");
                    answer++;
                }else{
                    //System.out.print(0+" ");
                }
            }
            // System.out.println();
        }


        System.out.println(answer);
    }

    public static void checkSticker(){

        for(int l=0;l<4;l++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(canPaste(i,j)){
                        pasteSticker(i,j);
                        return;
                    }
                }
            }

            turnSticker();
        }

    }

    public static boolean canPaste(int x,int y){

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(x+i >= n || y+j >= m) return false;
                if(sticker[i][j] && notebook[x+i][y+j]) return false;
            }
        }
        return true;
    }

    public static void pasteSticker(int x,int y){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(sticker[i][j]) notebook[x+i][y+j] = true;
            }
        }
    }

    public static void turnSticker(){
        boolean[][] tempSticker = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                tempSticker[i][j] = sticker[i][j];
            }
        }

        int temp = r;
        r = c;
        c = temp;

        sticker = new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sticker[i][j] = tempSticker[c-1-j][i];
            }
        }
    }
}
