class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int leftM = a[0];
        int rightM = a[a.length-1];
        
        for(int i=0; i<a.length; i++){
            if(leftM > a[i]) leftM = a[i];
            leftMin[i] = leftM;
        }
        
         for(int i=a.length-1; i>=0; i--){
            if(rightM > a[i]) rightM = a[i];
            rightMin[i] = rightM;
        }
        
        for(int i=1; i<a.length-1; i++){
            
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) continue;
            answer++;
            
        }
        
        // print(leftMin);
        // print(rightMin);

        
        
        return answer;
    }
    
    public void print(int[] arr){
        String tw= "";
        for(int t : arr){
            tw+=t+" ";
        }
        System.out.println(tw);
    }
}