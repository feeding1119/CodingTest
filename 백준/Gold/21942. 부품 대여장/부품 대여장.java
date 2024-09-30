

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Map<String,String[]>> map = new HashMap<>();
    static Map<String,Long> result = new HashMap<>();
    static String overDay,overH,overM;
    static int F;

    static int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String L = st.nextToken();

        F = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(L,"/");
        overDay = st.nextToken();
        st = new StringTokenizer(st.nextToken(),":");
        overH = st.nextToken();
        overM = st.nextToken();


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            String date = st.nextToken();
            String time = st.nextToken();
            String parts = st.nextToken();
            String name = st.nextToken();

            if(map.containsKey(parts)){
                if(checkName(parts,name)){
                    long pay = calcPay(date,time,parts,name);

                    Map<String,String[]> ls = map.get(parts);

                    ls.remove(name);

                    map.put(parts,ls);

                    if(pay > 0){
                        if(result.containsKey(name)){
                            result.put(name,result.get(name)+pay);
                        }else{
                            result.put(name,pay);
                        }
                    }

                }else{
                    Map<String,String[]> ls = map.get(parts);
                    ls.put(name,new String[]{date,time});
                    map.put(parts,ls);
                }
            }else{
                Map<String,String[]> ls = new HashMap<>();
                ls.put(name,new String[]{date,time});
                map.put(parts,ls);
            }

        }

        if(result.isEmpty()) System.out.println(-1);
        else{
            List<String> answer = new ArrayList<>();

            for(String key : result.keySet()){
                answer.add(key);
            }

            Collections.sort(answer);

            for(String ans : answer){
                System.out.println(ans+" "+result.get(ans));
            }
        }
    }

    private static long calcPay(String date, String time, String parts, String name) {
        int pay = 0;

        String[] rental = map.get(parts).get(name);


        int dateDiff = 0;

        String[] returnDate = date.split("-");
        String[] rentalDate = rental[0].split("-");

        dateDiff += (Integer.parseInt(returnDate[0])-Integer.parseInt(rentalDate[0])) * 365;

        if(!returnDate[1].equals(rentalDate[1])){
            int rentalMonth = Integer.parseInt(rentalDate[1]);
            int temp = monthDay[rentalMonth-1] - Integer.parseInt(rentalDate[2]);

            int returnMonth = Integer.parseInt(returnDate[1]);
            for(int i=rentalMonth+1 ; i<=12;i++){
                if(i == returnMonth){
                    temp += Integer.parseInt(returnDate[2]);
                    break;
                }

                temp +=  monthDay[i-1];
            }

            dateDiff = temp;
        }else{
            dateDiff = Integer.parseInt(returnDate[2]) - Integer.parseInt(rentalDate[2]);
        }

        if(dateDiff < Integer.parseInt(overDay)) return pay;
        String[] returnTime = time.split(":");
        String[] rentalTime = rental[1].split(":");

        int hourDiff = 0;
        if(Integer.parseInt(returnTime[0]) < Integer.parseInt(rentalTime[0])){
            dateDiff--;

            int returnH = Integer.parseInt(returnTime[0]) + 24;
            int rentalH = Integer.parseInt(rentalTime[0]);

            hourDiff = returnH - rentalH;
        }else{
            int returnH = Integer.parseInt(returnTime[0]);
            int rentalH = Integer.parseInt(rentalTime[0]);
            hourDiff = returnH - rentalH;
        }

        int minDiff = 0;
        if(Integer.parseInt(returnTime[1]) < Integer.parseInt(rentalTime[1])){
            hourDiff--;

            int returnM = Integer.parseInt(returnTime[1]) + 60;
            int rentalM = Integer.parseInt(rentalTime[1]);

            minDiff = returnM - rentalM;
        }else{
            int returnM = Integer.parseInt(returnTime[1]);
            int rentalM = Integer.parseInt(rentalTime[1]);

            minDiff = returnM - rentalM;
        }

        int totalDiff = dateDiff*24*60 + hourDiff*60 + minDiff;
        int ableDiff = Integer.parseInt(overDay)*24*60 + Integer.parseInt(overH)*60 + Integer.parseInt(overM);

        if(ableDiff >= totalDiff) return pay;

        pay = (totalDiff-ableDiff)*F;

        return pay;
    }

    static private boolean checkName(String parts,String name){
        if(map.get(parts).containsKey(name)) return true;

        return false;
    }
}
