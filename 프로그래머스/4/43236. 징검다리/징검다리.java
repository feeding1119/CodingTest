import java.util.*;

class Solution {
    
    static int answer =0;
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int[] diff = new int[rocks.length+1];
        
        diff[0] = rocks[0];
        for(int i=1;i<rocks.length;i++){
            diff[i] = rocks[i]-rocks[i-1];
        }
        
        diff[diff.length-1] = distance -rocks[rocks.length-1];
        
        dfs(0,distance,n,diff);
      
        return answer;
    }
    
    private void dfs(int start,int end,int n,int[] diff){
        int mid = (start+end)/2;
        
        if(start>= end) {
            if(checkDiff(mid,n,diff)) answer = mid;
            return;
        }
        
  
        if(checkDiff(mid,n,diff)){
            answer = mid;
            dfs(mid+1,end,n,diff);
        }else{
            dfs(start,mid,n,diff);
        }
        
    }
    
    private boolean checkDiff(int mid,int n,int[] diff){
        int count = 0;
        
        int[] newDiff = new int[diff.length];
        for(int i=0;i<diff.length;i++){
            newDiff[i] = diff[i];
        }
        
        
        
        for(int i=0;i<newDiff.length;i++){
            
            if(mid > newDiff[i]) {
                
                if(i != newDiff.length-1) newDiff[i+1] += newDiff[i];
                count++;
            }
            
            if(count > n) return false;
        }
        

        return true;
    }
}