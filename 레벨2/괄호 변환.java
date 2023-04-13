//https://school.programmers.co.kr/learn/courses/30/lessons/60058

import java.util.*;
import java.lang.*;

class Solution {
	
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")) return answer;
        
        if(isRightOne(p)) return p;

        return dc(p);
    }
    
    public String dc(String original){
        
    	if(original.equals("")) return "";
    	
        int left = 0;
        int right = 0;
        int i =0;
        for(; i<original.length(); i++){
            
            char next = original.charAt(i);
            if(next == '(') left++;
            else right++;
            
            if(left != 0 && right !=0 && left == right){
                break;
            }
            
        }
        
        String u = original.substring(0,i+1);
        String v = original.substring(i+1);
    
        System.out.println(u+"  "+v);

        if(isRightOne(u)) return u+dc(v);
        else{
            String temp = "("+dc(v)+")";
            String truncatedU ="";
            
            if(u.equals("") || u.length() == 2){
                
            }else{
                truncatedU = u.substring(1,u.length()-1);
            }
            
            StringBuilder b= new StringBuilder(truncatedU);
              
            for(int w=0; w<truncatedU.length(); w++){
                  b.setCharAt(w,getOpposite(truncatedU.charAt(w)));
              }
            
            return temp+b.toString();
            
        }
        
    }
    
    public boolean isRightOne(String str){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            
            char next = str.charAt(i);
            
            if(stack.isEmpty()){

                if(isRightFirstOne(next)) stack.push(next);
                else return false;
                
            }else{
                
                if(next==')' && stack.peek() == '(') stack.pop();
                else stack.push(next);
            }

        }
        
        if(!stack.isEmpty()) return false;
            
        return true;
        
        
    }
    
    public boolean isRightFirstOne(char c){
        boolean r= c=='('?true:false;
        return r;
    }
    
    public char getOpposite(char t){
        if(t == ')') return '(';
        else return ')';
    }
}