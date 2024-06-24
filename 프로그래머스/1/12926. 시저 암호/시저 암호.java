class Solution {
    public String solution(String s, int n) {
        Character[] input = new Character[s.length()];
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') input[i] = ' ';
            else{
                char temp = s.charAt(i);
                for(int j=0;j<n;j++){
                    if(temp == 'z' || temp == 'Z') temp -= 26;
                
                    temp += 1;
                }
                input[i] = temp;
                
            }
        }
        String answer = "";
        for(int i=0;i<input.length;i++){
            answer += input[i];
        }
        return answer;
    }
}