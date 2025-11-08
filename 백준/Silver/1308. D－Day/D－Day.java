import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static class Date{
        int y,m,d;

        public Date(int y,int m,int d){
            this.y = y;
            this.m = m;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        Date[] date = new Date[2];

        StringTokenizer st;

        for(int i=0;i<2;i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            date[i] = new Date(y,m,d);
        }


        if(date[1].y - date[0].y > 1000 || (date[1].y - date[0].y == 1000 && (date[1].m > date[0].m || (date[1].m == date[0].m && date[1].d >= date[0].d)))){
            System.out.println("gg");
            return;
        }


        int answer = calcDay(date[1]) - calcDay(date[0]);

        System.out.println("D-"+answer);



    }

    public static int calcDay(Date d){
        int result = 0;

        for(int i=1;i<d.y;i++){
            if(checkYear(i)) result += 366;
            else result += 365;
        }

        int[] md = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i=1;i<d.m;i++){
            result += md[i];
            if(i == 2 && checkYear(d.y)) result+=1;
        }

        result += d.d;


        return result;
    }

    public static boolean checkYear(int y){
        if(y%400 == 0) return true;
        if(y%100 == 0) return false;
        if(y%4 == 0) return true;
        return false;
    }

}
