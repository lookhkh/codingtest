class Solution {
    String[] arr = new String[]{"aya","ye","woo","ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        String r= "(aya|ye|woo|ma)+";
        
        for(String next : babbling){
            boolean isMatch = next.matches(r);
            if(!isMatch) continue;
            
            for(int i=0; i<arr.length; i++){
                next = next.replaceAll(arr[i],(i+1)+"");
            }
            
            char lastOne = '0';
            boolean result = true;
            
            for(int i=0; i<next.length(); i++){
                char nextOne = next.charAt(i);
                 if(lastOne == '0') {
                    lastOne = nextOne;
                }else{
                    if(nextOne == lastOne){
                        result = false;
                        break;
                    }else{
                        lastOne = nextOne;
                    }
                }
               
            }
            
            if(result) answer++;            
            
        }
        
        
        return answer;
    }
}