import java.util.*;

class Solution {
    
    static String[] op = {"+","-","*"};
    static boolean[] isUsed = new boolean[3];
    static long answer = 0;
    
    public long solution(String expression) {
        
        List<String> exp = new ArrayList<>();
        String num = "";
        for(int i=0; i<expression.length();i++){
            if(Character.isDigit(expression.charAt(i))){
                num += expression.charAt(i);
            }else{
                exp.add(num);
                exp.add(Character.toString(expression.charAt(i)));
                num = "";
            }
        }
        exp.add(num);
        
        dfs(exp,0);
        return answer;
    }
    
    
    public void dfs(List<String> exp,int count){
        if(exp.size() == 1){
            if(Math.abs(Long.parseLong(exp.get(0))) > answer) {
                answer = Math.abs(Long.parseLong(exp.get(0)));
            }
            return;
        }
        for(int i=0;i<3;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                List<String> afterExp = calcExpression(op[i],exp);
                dfs(afterExp, count+1);
                isUsed[i] = false;
            }
        }
    }
    
    public List<String> calcExpression(String op,List<String> exp){
        List<String> result = new ArrayList<>();
        
        long number = 0;
        int index = 0;
        
        while(index < exp.size()){
            if(exp.get(index).equals(op)){
                if(op.equals("*")){
                    number *= Long.parseLong(exp.get(index+1));                 
                }else if(op.equals("-")){
                    number -= Long.parseLong(exp.get(index+1));
                }else if(op.equals("+")){
                    number += Long.parseLong(exp.get(index+1));
                }
                
                index++;
            }else if(exp.get(index).equals("*") 
                     || exp.get(index).equals("-") || exp.get(index).equals("+")){
                result.add(Long.toString(number));
                number = 0;
                result.add(exp.get(index));
            }else{
                number = Long.parseLong(exp.get(index));
            }
            index++;
        }
        result.add(Long.toString(number));
        
        return result;
    }
}