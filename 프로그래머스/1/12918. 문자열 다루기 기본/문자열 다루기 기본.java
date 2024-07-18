class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        int len = s.length();
        if(len == 4 || len == 6){
            for(int i=0;i<len;i++){
                if(!Character.isDigit(s.charAt(i))) return answer;
            }
            
            answer = true;
        }
        return answer;
    }
}