class Solution {
    public int[] solution(long n) {
        String number = Long.toString(n);
        int nSize = number.length();
        
        int[] answer = new int[nSize];
        
    
        for(int i=0;i<nSize;i++){
            answer[i] = number.charAt(nSize-i-1)-'0';
        }
        return answer;
    }
}