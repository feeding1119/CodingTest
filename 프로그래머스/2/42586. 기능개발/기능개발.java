import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int pLen = progresses.length;
        int[] date = new int[pLen];
        
        for(int i = 0 ; i<pLen ; i++){
            
            int remaining = 100 - progresses[i];
            date[i] = remaining/speeds[i];
            
            if(remaining%speeds[i] != 0) date[i]++;
            
            // System.out.print(date[i]+" ");
        }
        
        int maxDate = date[0];
        int count = 1;
        
        for(int i=1;i<pLen;i++){
            if(date[i] <= maxDate) count++;
            else{
                result.add(count);
                maxDate = date[i];
                count = 1;
            }
        }
        result.add(count);
        
        
        
        int[] answer = new int[result.size()];
        
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}