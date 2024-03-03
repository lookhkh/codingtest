class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        while(!s.equals("1")){
            cnt++;
            String replace = "";
            for(int i=0; i<s.length(); i++){
                char next = s.charAt(i);
                if(next =='0') zero++;
                else replace+="1";
            }
            s = Integer.toBinaryString(replace.length());
            
        }
        
        answer[0] = cnt;
        answer[1] = zero;
        
        return answer;
    }
}