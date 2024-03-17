import java.util.*;
class Solution {
    List<String> opers = Arrays.asList("+","-","*");
    List<Map<String,Integer>> list = Arrays.asList(
        Map.of("+",1,"-",2,"*",3),
        Map.of("+",1,"-",3,"*",2),
        Map.of("-",1,"+",2,"*",3),
        Map.of("-",1,"+",3,"*",2),
        Map.of("*",1,"+",3,"-",2),
        Map.of("*",1,"+",2,"-",3)
    );
    public long solution(String expression) {
        long answer = 0;
        List<String> exps = convert(expression);

        for(Map<String,Integer> p : list){
            
            Stack<String> nums = new Stack<>();
            Stack<String> opers = new Stack<>();

            for(String exp : exps){
               if(!isOper(exp)) nums.push(exp);
               else{
                    
                   if(opers.isEmpty()) opers.push(exp);
                   else{
                       
                     int curP = p.get(exp);
                      
                     while(!opers.isEmpty() && curP <= p.get(opers.peek())){
                             
                        String last = nums.pop();
                        String first = nums.pop();
                        String oper = opers.pop();
                             
                        String result = calc(first, oper, last);
                        nums.push(result);
                    }
                         
                    opers.push(exp);
                         
                     }
                   }
                   
               }
              
                while(!opers.isEmpty()){
                    String last = nums.pop();
                    String first = nums.pop();
                    String oper = opers.pop();
                    
                    String rr = calc(first, oper,last);
                    nums.push(rr);
                }
            
                String r = nums.pop();
                answer = Math.max(answer, Math.abs(Long.parseLong(r))); 
            
            }
        
        return answer;
    }
    
    String calc(String first, String oper, String last){
        
        if(oper.equals("*")) return (Long.parseLong(first) * Long.parseLong(last))+"";
        if(oper.equals("+")) return (Long.parseLong(first) + Long.parseLong(last))+"";
        return (Long.parseLong(first) - Long.parseLong(last) )+"";
        
    }
    
    boolean isOper(String e){
        return opers.contains(e);
    }
    
    List<String> convert(String exp){
        List<String> c = new ArrayList<>();
        String temp = "";
        for(char next : exp.toCharArray()){
            if(Character.isDigit(next)){
                temp+= next;
            }else{
                c.add(temp);
                c.add(next+"");
                temp = "";
                
            }
        }
        c.add(temp);
        return c;
    }
    
}