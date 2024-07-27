class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        
        for(int i=left ;i<=right;i++){
            double temp = Math.sqrt(i);
            if((int)temp == temp) answer -= i;
            else answer += i;
        }
        
        return answer;
    }
}