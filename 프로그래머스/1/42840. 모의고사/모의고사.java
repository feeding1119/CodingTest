import java.util.*;

class Solution {
    static int maxScore = -1;
    static int maxCount = 0;
    static List<int[]> stuAnswers = new ArrayList<>();
    static List<Integer> maxList = new ArrayList<>();
    
    public int[] solution(int[] answers) {
        stuAnswers.add(new int[]{1,2,3,4,5});
        stuAnswers.add(new int[]{2,1,2,3,2,4,2,5});
        stuAnswers.add(new int[]{3,3,1,1,2,2,4,4,5,5});
        
        checkAnswer(1,answers);
        checkAnswer(2,answers);
        checkAnswer(3,answers);
        
        
        int[] answer = new int[maxList.size()];
        for(int i =0;i<maxList.size();i++){
            answer[i] = maxList.get(i);
        }
    
        return answer;
    }
    
    public int checkAnswer(int num , int[] answer){
        int stuSize = stuAnswers.get(num-1).length;
        
        int index = 0;
        int score = 0;
        for(int i=0; i<answer.length;i++ ){
            if(index == stuSize) index = 0;
            
            if(stuAnswers.get(num-1)[index++] == answer[i]) score++;
        }
        
        if(score > maxScore) {
            maxScore = score;
            maxList = new ArrayList<>();
            maxList.add(num);
        }else if(score == maxScore){
            maxList.add(num);
        }
        
        return score;
    }

}