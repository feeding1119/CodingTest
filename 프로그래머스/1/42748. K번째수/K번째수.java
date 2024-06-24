import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            
            int arrSize = end-start+1;
            int[] tempArray = new int[arrSize];
            
            for(int j=0;j<arrSize;j++){
                tempArray[j] = array[start-1+j];
            }
            
            Arrays.sort(tempArray);
            
            answer[i] = tempArray[index-1];
        }
        
        return answer;
    }
}