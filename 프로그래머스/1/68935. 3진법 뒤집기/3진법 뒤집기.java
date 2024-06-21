class Solution {
    public int solution(int n) {      
        return transNumber(n);
    }
    
    public int transNumber(int n){
        String result = "";
        
        while(n>=3){
            result += n%3;
            n /= 3;
        }
        result += n;
        
        int answer = 0;
        
        int digit = 1;
        for(int i=result.length()-1;i>=0;i--){
            answer += (result.charAt(i)-'0')* digit;
            digit *= 3;
        }
        
        return answer;
    }
}