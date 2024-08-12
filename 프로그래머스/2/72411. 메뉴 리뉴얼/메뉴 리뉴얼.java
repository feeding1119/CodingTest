import java.util.*;

class Solution {
    
    static Map<Character,Integer> map = new HashMap<>();
    static int count =1;
    static List<String> ls = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        
        checkMenu(orders);
        
        char[] order = new char[map.size()];
  
        int index = 0;
        for(char key:map.keySet()){
            order[index++] = key;
        }
        
        Arrays.sort(order);
        
        for(int i=0;i<course.length;i++){
            count = 1;
            ls.clear();
            
            dfs(order,"",course[i],0,orders);
            
            for(String tt: ls){
                result.add(tt);
            }
            
        }
        
        String[] answer = new String[result.size()];
        Collections.sort(result);
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void dfs(char[] order , String menu,int n,int idx,String[] orders){
        if(menu.length() == n){
            int c = countMenu(orders,menu);
            if(c > count){
                count = c;
                ls.clear();
                ls.add(menu);
            }else if(c == count && count != 1){
                ls.add(menu);
            }
            return;
        }
        
        for(int i=idx;i<order.length;i++){
            dfs(order,menu+order[i],n,i+1,orders);
        }
    }
    
    public void checkMenu(String[] orders){
        for(String order : orders){
            for(int i=0;i<order.length();i++){
                map.put(order.charAt(i),1);
            }
        }
    }
    
    public int countMenu(String[] orders , String menu){
        int result =0;
        for(int i=0;i<orders.length;i++){
            int temp =0;
            boolean isAble = false;
            for(int j=0;j<menu.length();j++){
                for(int k=0;k<orders[i].length();k++){
                    if(menu.charAt(j) == orders[i].charAt(k)){
                        temp++;
                        isAble =true;
                        break;
                    }
                }
                
                if(!isAble) break;
            }
            
            if(temp == menu.length()) result++;
        }
        return result;
    }
}