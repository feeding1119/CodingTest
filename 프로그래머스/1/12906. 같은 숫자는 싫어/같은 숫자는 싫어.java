import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ls = new ArrayList<>();
        
        int prev = arr[0];
        ls.add(prev);
        
        for(int i=1;i<arr.length;i++){
            if(prev != arr[i]){
                ls.add(arr[i]);
            }
            prev = arr[i];
        }

        int[] answer = new int[ls.size()];
        
        for(int i=0;i<ls.size();i++){
            answer[i] = ls.get(i);
        }
        return answer;
    }
}