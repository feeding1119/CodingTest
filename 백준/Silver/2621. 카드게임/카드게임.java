
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String[] colors = new String[5];
    static int[] nums = new int[5];
    static int[] count = new int[10];
    static int plus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());

            colors[i] = st.nextToken();
            nums[i] = Integer.parseInt(st.nextToken());

            count[nums[i]]++;
        }

        Arrays.sort(nums);

        plus = nums[4];

        System.out.println(calcScore());
    }

    public static int calcScore(){

        if(isRoyalStarightFlush()) return plus+900;

        if(isFourCard()) return plus+800;

        if(isFullHouse()) return plus+700;

        if(isFlush()) return plus+600;

        if(isStraight()) return plus+500;

        if(isTriple()) return plus+400;

        if(isTwoPair()) return plus+300;

        if(isOnePair()) return plus+200;
        return plus+100;
    }

    public static boolean isRoyalStarightFlush(){
        if(isFlush() && isStraight()) {
            plus = nums[4];
            return true;
        }
        return false;
    }

    public static boolean isFourCard(){
        for(int i=1;i<10;i++){
            if(count[i] == 4){
                plus = i;
                return true;
            }
        }
        return false;
    }

    public static boolean isFullHouse(){
        boolean isThree = false;
        int threeNum = 0;
        boolean isTwo = false;
        int twoNum = 0;
        for(int i=1;i<10;i++){
            if(count[i] == 3) {
                threeNum = i;
                isThree = true;
            }
            if(count[i] == 2) {
                twoNum = i;
                isTwo = true;
            }
        }

        if(isThree && isTwo){
            plus = threeNum*10+ twoNum;
            return true;
        }
        return false;
    }

    public static boolean isFlush(){
        String firstColor = colors[0];

        for(int i=1;i<5;i++){
            if(!firstColor.equals(colors[i])) return false;
        }


        return true;
    }

    public static boolean isStraight(){
        int prevNum = nums[0];

        for(int i=1;i<5;i++){

            if(nums[i] - prevNum != 1) return false;
            prevNum =nums[i];
        }

        return true;
    }

    public static boolean isTriple(){
        for(int i=1;i<10;i++){
            if(count[i] == 3){
                plus = i;
                return true;
            }
        }
        return false;
    }

    public static boolean isTwoPair(){
        int twoCount = 0;
        int[] twoValue = new int[2];
        int index = 0;
        for(int i=1;i<10;i++){
            if(count[i] == 2){
                twoCount++;
                twoValue[index++] = i;
            }
        }

        if(twoCount == 2){
            if(twoValue[0] > twoValue[1]){
                plus = twoValue[0] * 10 + twoValue[1];
            }else{
                plus = twoValue[1] * 10 + twoValue[0];
            }
            return true;
        }
        return false;
    }

    public static boolean isOnePair(){
        for(int i=1;i<10;i++){
            if(count[i] == 2){
                plus = i;
                return true;
            }
        }
        return false;
    }
}
