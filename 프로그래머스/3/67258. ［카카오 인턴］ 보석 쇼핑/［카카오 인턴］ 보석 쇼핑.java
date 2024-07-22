import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Map<String,Integer> map = new HashMap<>();
        
        for(String gem : gems){
            map.put(gem,1);
        }
        
        int gemSize = map.size();
        
        map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        map.put(gems[end],1);
        int minValue = Integer.MAX_VALUE;
        while(end < gems.length){
            if(start > end) break;
    
            // System.out.println("시작"+start+"끝"+end+"맵사"+map.size()+"잼사"+gemSize);
            if(map.size() == gemSize){
                if(minValue > end-start+1){
                    minValue = end-start+1;
                    answer[0] = start+1;
                    answer[1] = end+1;
                    if(minValue == gemSize) break;
                }
                if(map.get(gems[start]) != null){
                    if(map.get(gems[start])-1 == 0){
                        map.remove(gems[start]);
                    }else{
                        map.put(gems[start],map.get(gems[start])-1);
                    }
                    
                }
            
                start++;
            }else{
                end++;
                if(end != gems.length){
                    if(map.get(gems[end]) == null){
                        map.put(gems[end],1);
                    }else{
                        map.put(gems[end],map.get(gems[end])+1);
                    }
                    
                }
                
            }
        }
        return answer;
    }
}