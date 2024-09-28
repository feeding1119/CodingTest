import java.util.*;

class Solution {
    
    static Map<Integer,Integer> answer = new HashMap<>();
    
    public int solution(String numbers) {
        
        int len = numbers.length();
        int[] number = new int[len];
    

        for(int i=0;i<len;i++){
            number[i] = numbers.charAt(i) - '0';
        }
        
        dfs(number,new boolean[len],len,"");
        return answer.size();
    }
    
    public void dfs(int[] number,boolean[] isUsed,int len,String value){
        for(int i=0;i<len;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                String tempValue = value + number[i];
                if(isPrime(Integer.parseInt(tempValue))) answer.put(Integer.parseInt(tempValue),1);
                dfs(number,isUsed,len,tempValue);
                isUsed[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n){
        int temp = (int)Math.sqrt(n);
        
        if(n == 0 || n == 1) return false;
        for(int i=2;i<=temp;i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
}