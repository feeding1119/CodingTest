import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int k = queries[i][2];
            int e = queries[i][1];
            int s = queries[i][0];
            
            List<Integer> temp = new ArrayList<>();
            
            for(int j=s;j<=e;j++){
                if(arr[j]>k) temp.add(arr[j]);
            }
            
            Collections.sort(temp);
            
            if(temp.size() == 0){
                answer[i] = -1;
            }else{
                answer[i] = temp.get(0);
            }
            
            
        }
        return answer;
    }
}