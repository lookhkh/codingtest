//https://school.programmers.co.kr/learn/courses/30/lessons/161990

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        //가장 왼쪽에 있는 값 : luy
        //왼쪽 가장 위에 잆는 값 : lux
        //가장 오른쪽에 있는 값 : rdy 
        //가장 아래에 있는 값 : rdx
        
        int lux = -1;
        int luy = -1;
        int rdx = -1;
        int rdy = -1;
        
        for(int i=0; i<wallpaper.length; i++){
            
            String row = wallpaper[i];
            
            for(int j=0; j<row.length(); j++){
                
                char nextChar = row.charAt(j);
                
                if(nextChar == '#'){
                    
                    if(lux == -1 || lux > i){
                        lux = i;
                    }
                    
                    if(luy == -1 || luy > j){
                        luy = j;
                    }
                    
                    if(rdx == -1 || rdx < i){
                        rdx = i;
                    }
                    
                    if(rdy == -1 || rdy < j){
                        rdy = j;
                    }
                    
                }
                
            }
            
        }
        
        System.out.println(lux+" "+luy+" "+rdx+" "+rdy);
        
        
        
        return new int[]{lux,luy,rdx+1,rdy+1};
    }
}