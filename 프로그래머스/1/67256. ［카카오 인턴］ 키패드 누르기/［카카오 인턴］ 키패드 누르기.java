class Solution {
    public String solution(int[] numbers, String hand) {
        
        int leftHand = 10;
        int rightHand = 12;
        
        String answer = "";
        for(int num:numbers){
            if(num == 1 || num == 4 || num == 7){
                leftHand = num;
                answer +="L";
            }
            
            if(num == 3 || num == 6 || num == 9){
                rightHand = num;
                answer +="R";
            }
            
            if(num == 2 || num == 5 || num == 8 || num == 0 || num == 11){
                if(num == 0) num = 11;
                
                int leftDiff = Math.abs(num - leftHand);
                int left = leftDiff%3 + leftDiff/3;
                int rightDiff = Math.abs(num - rightHand);
                int right = rightDiff%3 + rightDiff/3;
                
                if(left < right || (left == right) && hand.equals("left")){
                    leftHand = num;
                    answer += "L";
                }else if(right < left || (left == right) && hand.equals("right")){
                    rightHand = num;
                    answer += "R";
                }
            }            
            
        }
        
        return answer;
    }
}