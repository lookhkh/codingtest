/*
    JadenCase
    1. 모든 단어의 첫 문자가 대문자이고, 그외 알파벳은 전부 소문자
    2. 첫 문자가 알파벳이 아닌 경우, 이어지는 알파벳은 소문자.
    3. 입력값은 알바펫, 숫자, 공백문자로 이루어짐.
        3.1 숫자는 단어의 첫 문자로만 등장.
        3.2 숫자로만 이루어진 단어는 없음
        3.3 공백문자가 연속해서 등장 가능.

*/
import java.lang.StringBuilder;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s.length());
        
        String[] ss = s.split(" ");
        
        for(int i=0; i<ss.length; i++){
            
            String next = ss[i];

            if(next.length() == 0 ) answer.append(next);
            else{
                
                char first = next.charAt(0);
                if(first >='0' && first <='9'){
                    answer.append(next.toLowerCase());
                }else{
                    answer.append(next.substring(0,1).toUpperCase()+next.substring(1).toLowerCase());
                }
                
            }
            answer.append(" ");
        }
        
        
        System.out.println(answer.length()-1+" "+s.length());
        if(answer.length()-1<s.length()){
            
            for(int i=answer.length()-1; i<s.length(); i++){
                answer.append(" ");
            }
            
        }
        
        
        return answer.toString().substring(0,answer.length()-1);
    }
}