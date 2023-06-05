class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            
            int a = arr1[i];
            int b = arr2[i];
            
            int re = a | b;
              
            String r = Integer.toBinaryString(re);
            
            while(r.length()< n){
                r="0"+r;
            }
            
            r = r.replaceAll("1","#").replaceAll("0"," ");
            
            
            answer[i] = r;
            
        }
        
        return answer;
    }
}