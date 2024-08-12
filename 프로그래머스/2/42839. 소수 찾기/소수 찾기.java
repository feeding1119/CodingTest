import java.util.*;

class Solution {
    static Map<Integer,Integer> map = new HashMap<>();
    public int solution(String numbers) {
        
        char[] num = new char[numbers.length()];
        boolean[] isUsed = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++){
            num[i] = numbers.charAt(i);
        }
        
        dfs(num,"",isUsed);
            
        return map.size();
    }
    
    
    public void dfs(char[] numbers,String value,boolean[] isUsed){
        
        if(!value.equals("")){
            if(isPrime(Integer.parseInt(value)))map.put(Integer.parseInt(value),1);
            
        }
        
        for(int i=0;i<numbers.length;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                dfs(numbers,value+numbers[i],isUsed);
                isUsed[i] = false;
            }
        }
    }
    
    
    public boolean isPrime(int n){
        
        if(n==0 || n==1) return false;
        int num = (int)Math.sqrt((double)n);
        
        for(int i=2;i<=num;i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
}