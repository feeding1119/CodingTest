class Solution {
    public int[] solution(int brown, int yellow) {
        
        int num = yellow;
        
        int width = 0;
        int height = 0;
        
        while(num>0){
            if(yellow%num == 0){
                int x = num+2;
                int y = (yellow/num)+2;  
                
                int total = 2*x + 2*y - 4;
                
                if(total == brown){
                    width = x;
                    height = y;
                    break;
                }
            }
            
            num--;
            
        }
        int[] answer = {width,height};
        return answer;
    }
}