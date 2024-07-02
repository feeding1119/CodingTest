import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        boolean check = true;

        Queue<String> q = new LinkedList<>();
        
        for(int i = 0 ; i< s.length();i++){
            String temp = String.valueOf(s.charAt(i));
            
            if(temp.equals("(")){
                q.offer("(");
            }
            
            if(temp.equals(")")){
                if(q.isEmpty()) {
                    check = false;
                    break;
                }
                q.poll();
            }
            
        }
        
        if(check && q.isEmpty()) answer = true;

        return answer;
    }
}