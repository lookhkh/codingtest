class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length; i++){
            for(int j=0; j<number.length && i!=j; j++){
                for(int z=0; z<number.length && z!=i && z!=j; z++){
                    int first = number[i];
                    int second = number[j];
                    int third = number[z];
                    
                    if(first+second+third == 0) answer++;
                    
                }
            }
        }
        
        return answer;
    }
}