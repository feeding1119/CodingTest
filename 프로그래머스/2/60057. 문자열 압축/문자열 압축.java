import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=1;i<=s.length();i++){
            
            int start = 0;
            
            int count = 1;
            String prev = "";
            String result = "";
            String temp = "";
            while(start<s.length()){
                
                if(start+i > s.length()) temp =s.substring(start);
                else temp = s.substring(start,start+i);
        
                if(start == 0){
                    start += i;
                    prev = temp;
                    continue;
                }
                
                if(prev.equals(temp)) count++;
                else{
                    if(count != 1){
                        result +=count;
                    }   
                    result += prev;
                    prev = temp;
                    count = 1;
                }
                
                start += i;
                
            }
            
            if(count != 1){
                result+=count;
            }
            result += temp;

            if(result.length() < answer) answer = result.length();
        }
        return answer;
    }
}