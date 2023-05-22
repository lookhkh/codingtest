/*
    파일 정렬
   단, 파일에 포함된 숫자를 반영하여 정렬해야 한다.
   파일명은 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")로 생김
   숫자를 하나 이상 포함하고 있다.
   
   1. 헤드를 기준으로 정렬. 대소문자는 구분하지 않는다.
   2. 정렬 이후, number의 숫자로 정렬한다.
   3. HEAD, NUMBER가 같을 경우, 입력과 동일한 순서를 유지한다.
   
*/
import java.util.*;
class Solution {
    
    static class File{
        String original;
        String head;
        String number;
        
        public File(String fileName){
            String[] arr = getDelimtedName(fileName);
            this.original = fileName;
            this.head = arr[0].toLowerCase();
            this.number = arr[1];
            
        }
        
        @Override
        public String toString(){
            return this.original+"  "+this.head+"  "+this.number;
        }
        
        private String[] getDelimtedName(String name){
            String[] arr = new String[2];
            
            int i = 0;
            
            for(; i < name.length(); i++){
                
                char t = name.charAt(i);
                if(t >='0' && t<='9') break;    
                
            }
            
            arr[0] = name.substring(0,i);
            
            int cnt = 0;
            for(; cnt<5; cnt++){
                if(i+cnt >= name.length()) break;
                char n = name.charAt(i+cnt);
                if(!(n >='0' && n <='9')) break;
            }
            
            arr[1] = name.substring(i,i+cnt);
            
        
        return arr;
        
    }
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<>();
        for(String file : files){
            File f = new File(file);
            list.add(f);
        }
        
        list.sort((t1,t2)->{
           
            if(!t1.head.equals(t2.head)) {
                return t1.head.compareTo(t2.head);
            }
            
            if(!t1.number.equals(t2.number)){
                return Integer.compare(Integer.valueOf(t1.number), Integer.valueOf(t2.number));
            }
            
            return 0;
        });
        
        return list.stream()
                   .map(t->t.original)
                   .toArray(String[]::new);
        
    }
    
   
}