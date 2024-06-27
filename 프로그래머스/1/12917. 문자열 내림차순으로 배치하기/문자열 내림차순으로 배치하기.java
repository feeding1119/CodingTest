import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] strs = new Character[s.length()];
        
        for(int i=0;i<s.length();i++){
            strs[i] = s.charAt(i);
        }
        
        Arrays.sort(strs,Collections.reverseOrder());
        
        String answer = "";
        
        for(Character c : strs){
            answer += c;
        }
        
        return answer;
    }
}