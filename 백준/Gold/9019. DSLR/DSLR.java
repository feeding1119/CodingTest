import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            System.out.println(bfs(a,b));
        }
    }

    public static String bfs(String a,String b){
        Queue<String[]> q = new LinkedList<>();

        boolean[] v = new boolean[10000];

        v[Integer.parseInt(a)] = true;

        q.offer(new String[]{a,""});
        while(!q.isEmpty()){
            String[] temp = q.poll();

            String num = temp[0];
            String com = temp[1];

            int d = commandD(num);

            if(d == Integer.parseInt(b)) return com+"D";
            if(!v[d]){
                v[d] = true;
                q.offer(new String[]{String.valueOf(d),com+"D"});
            }

            int s = commandS(num);

            if(s == Integer.parseInt(b)) return com+"S";
            if(!v[s]){
                v[s] = true;
                q.offer(new String[]{String.valueOf(s),com+"S"});
            }

            int l = commandL(num);

            if(l == Integer.parseInt(b)) return com+"L";
            if(!v[l]){
                v[l] = true;
                q.offer(new String[]{String.valueOf(l),com+"L"});
            }

            int r = commandR(num);

            if(r == Integer.parseInt(b)) return com+"R";
            if(!v[r]){
                v[r] = true;
                q.offer(new String[]{String.valueOf(r),com+"R"});
            }

        }

        return "";
    }


    public static int commandD(String num){
        int temp = (Integer.parseInt(num)*2)%10000;

        return temp;

    }

    public static int commandS(String num){
        int temp = Integer.parseInt(num)-1;

        if(temp == -1) temp = 9999;

        return temp;
    }

    public static int commandL(String num){
        String temp = "";

        int zero = 4-num.length();

        for(int i=0;i<zero;i++){
            temp += "0";
        }

        temp += num;

        String result = "";
        for(int i=1;i<=temp.length();i++){
            result += temp.charAt(i%temp.length());
        }

        return Integer.parseInt(result);

    }

    public static int commandR(String num){
        String temp = "";

        int zero = 4-num.length();

        for(int i=0;i<zero;i++){
            temp += "0";
        }

        temp += num;

        String result = "";

        result += temp.charAt(temp.length()-1);

        for(int i=0;i<temp.length()-1;i++){
            result += temp.charAt(i);
        }

        return Integer.parseInt(result);
    }
}
