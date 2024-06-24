class Solution {
    public String solution(String s) {
        String answer = "";
        
        int index = 0;
        for(int i=0;i<s.length();i++){
            String temp = String.valueOf(s.charAt(i));
            
            if(temp.equals(" ")){
                index = 0;
                answer += " ";
                continue;
            }
            
            if(index++ % 2 == 0){
                answer += temp.toUpperCase();
            }else{
                answer += temp.toLowerCase();
            }
         
        }
        return answer;
    }
}