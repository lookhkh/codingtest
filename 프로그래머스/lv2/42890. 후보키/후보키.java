import java.util.Arrays;
import java.util.*;

class Solution {
    
    Map<Integer, List<List<Integer>>> ch;
    
    int answer = 0;
    
    public int solution(String[][] relation) {
        
        int colNums = relation[0].length;
        
        ch = new HashMap<>();
        
        for(int i=1; i<=colNums; i++){
            ch.put(i,new ArrayList<>());
        }

        
        for(int i=1; i<=colNums; i++){
            
            combination(i,0,0,new ArrayList<>(),relation);
        }
        
        
        return answer;
    }
    
    public void combination(int targetNum, int current, int startIdx, List<Integer> path, String[][] relation){
        
        if(targetNum == current){
            
            for(int z=1; z<=current; z++){
            
                List<List<Integer>> list = ch.get(z);

                if(list != null){

                    for(int i=0; i<list.size(); i++){

                        List<Integer> subList = list.get(i);

                        if(path.containsAll(subList)) return;

                    }

                }
            }
            
            
                for(int x=0; x<relation.length; x++){
                    
                    String[] xr = relation[x];
                    String xxx = "";
                    
                    for(int y=x+1; y<relation.length; y++){
                        
                        String[] yr = relation[y];
                        String yyy = "";
                        
                        for(int i=0; i<path.size(); i++){
                            
                            int col = path.get(i);
                            
                            xxx+=xr[col];
                            yyy+=yr[col];
                            
                        }
                        
                        
                        if(xxx.equals(yyy)) return;
                        xxx = "";
                    }
                    
                }
        

                
                List<Integer> newList = new ArrayList<>();
                newList.addAll(path);
            
                ch.get(targetNum).add(newList);
        

                this.answer++;
            
            
            }else{
            
            for(int i =startIdx; i<relation[0].length; i++){
                                
                path.add(i);
                combination(targetNum,current+1,i+1,path,relation);
                path.remove(path.size()-1);
                
            }
            
            
        }
        
    }
}