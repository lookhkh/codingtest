class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i=0; i<number.length; i++){
            int a = number[i];
            for(int j=0; j!=i && j<number.length; j++){
                int b = number[j];
                for(int z=0; z!=j&&z!=i&&z<number.length; z++){
                    int c = number[z];
                    if(a+b+c==0) answer++;
                }
            }
        }
        return answer;
    }
}