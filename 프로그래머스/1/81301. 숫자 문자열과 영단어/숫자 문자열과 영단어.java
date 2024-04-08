import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        String answer = "";
        
        int len = s.length();
        
        Map<String,Integer> number = new HashMap<>();
        
        number.put("zero",0);
        number.put("one",1);
        number.put("two",2);
        number.put("three",3);
        number.put("four",4);
        number.put("five",5);
        number.put("six",6);
        number.put("seven",7);
        number.put("eight",8);
        number.put("nine",9);
        
        String temp = "";
        
        for(int i=0;i<len;i++){
            
            if(number.get(temp) != null){
                answer += number.get(temp);
                    temp = "";
            }
            
            if(Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
            }else{
                temp += s.charAt(i);
            }
            
        }
        
        if(number.get(temp) != null){
            answer += number.get(temp);
        }
        
        return Integer.parseInt(answer);
    }
}