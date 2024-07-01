import java.util.*;


class Solution {
    public String solution(String my_string) {
        
        Map<Character,Integer> map = new HashMap<>();
        
        String answer = "";
        for(int i=0;i<my_string.length();i++){
            Character my_char = my_string.charAt(i);
            
            if(map.get(my_char) == null){
                answer += my_char;
                map.put(my_char,1);
            }
            
            
        }
        
        return answer;
    }
}