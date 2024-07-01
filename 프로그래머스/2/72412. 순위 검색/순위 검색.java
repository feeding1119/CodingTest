import java.util.*;

class Solution {
    
    static Map<String,List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        for(String cond : info){
            dfs(0,"",cond.split(" "));
        }

        for(List<Integer> ls : map.values()){
            Collections.sort(ls);
        }
        
        int[] answer = new int[query.length];
        
        for(int i=0;i<query.length;i++){
            String[] spec = query[i].split(" and ");
            
            String[] temp = spec[3].split(" ");
            
            int target = Integer.parseInt(temp[1]);
            spec[3] = temp[0];
            
            String key = "";
            for(int j=0;j<4;j++){
                key+=spec[j];
            }
            
            if(map.containsKey(key)){
                List<Integer> scoreList = map.get(key);
                int start = 0;
                int end = scoreList.size()-1;
                
                while(start<=end){
                    int mid = (start+end)/2;
                            
                    if(scoreList.get(mid) < target){
                        start = mid+1;
                    }else{
                        end = mid-1;
                    }
                }
                
                answer[i] = scoreList.size() - start;
            }
        }
        return answer;
    }
    
    public void dfs(int depth,String query,String[] info){
        if(depth == 4){
            if(!map.containsKey(query)){
                List<Integer> score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                map.put(query,score);
            }else{
                map.get(query).add(Integer.parseInt(info[4]));
            }
            
            return;
        }
        dfs(depth+1,query+"-",info);
        dfs(depth+1,query+info[depth],info);
    }
}