import java.util.Arrays;
class Solution {
    int[] arr = new int[26];
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(arr,-1);
        
        for(int i=0; i<s.length(); i++){
            
            char next = s.charAt(i);
            if(arr[next-'a'] == -1){
                answer[i] = -1;
                arr[next-'a'] = i;
            }else{
                answer[i] = i - arr[next-'a'];
                arr[next-'a'] = i;
            }
            
        }
        
        return answer;
    }
}