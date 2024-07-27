import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            String bit = Long.toBinaryString(numbers[i]);
            
            StringBuilder sb = new StringBuilder();
            sb.append(bit);
            sb.reverse();
            
            if(numbers[i] % 4 == 3){
                String temp = sb.toString();
                if(!checkZero(temp)) temp+="0";
                
                
                temp = temp.replaceFirst("10","01");
                
                long value = 0;
                for(int j=0;j<temp.length();j++){
                    if(temp.charAt(j) == '1') value += Math.pow(2,j);
                }
                answer[i] = value;
            }else{
                answer[i] = numbers[i]+1;
            }
        }
        return answer;
    }
    
    public boolean checkZero(String temp){
        for(int j=0;j<temp.length();j++){
            if(temp.charAt(j) == '0') return true;
        }
        
        return false;
    }
    
}