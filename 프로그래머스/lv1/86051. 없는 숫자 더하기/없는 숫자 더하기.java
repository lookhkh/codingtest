class Solution {
   
    int[] arr = new int[10];
   
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int num : numbers){
            arr[num]++;
        }
        
        for(int i=0; i<arr.length;i++){
            if(arr[i] == 0) answer+=i;
        }
        
        return answer;
    }
}