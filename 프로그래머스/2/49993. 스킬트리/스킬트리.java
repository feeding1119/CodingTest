import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character,Integer> map = new HashMap<>();
        
        int level = 1;
        for(int i = 0 ; i< skill.length();i++){
            map.put(skill.charAt(i),level++);
        }
        
        int answer = 0;
        for(int i = 0 ; i< skill_trees.length; i++){
            String temp = "";
            Boolean isAble = true;
            for(int j = 0; j<skill_trees[i].length();j++){
                if(map.containsKey(skill_trees[i].charAt(j))){
                    temp += map.get(skill_trees[i].charAt(j));
                }
            }
            
            for(int j=0;j<temp.length();j++){
                if(j==0){
                    if(temp.charAt(j) != '1'){
                        isAble = false;
                        break;
                    }
                }else if(temp.charAt(j)-temp.charAt(j-1) != 1){
                    isAble = false;
                    break;
                }
            }
            
            if(isAble) answer++;
            
        }
        
        return answer;
    }
}