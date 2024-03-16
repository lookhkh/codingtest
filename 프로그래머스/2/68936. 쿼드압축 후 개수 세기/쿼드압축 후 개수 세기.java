class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int[] r =  compress(arr.length, 0,0, arr);
        answer[0] = r[1];
        answer[1] = r[0];
        return answer;
    }
    
    int[] compress(int len, int y, int x, int[][] arr){
        int zero = 0;
        int one = 0;
        for(int i=y; i<y+len; i++){
            for(int j=x; j<x+len; j++){
                int next = arr[i][j];
                if(next == 0) zero++;
                else one++;
            }
        }

        if ((zero == 0 && one != 0) || (zero !=0 && one ==0 )) {
            if(zero == 0) return new int[]{1,0};
            return new int[]{0,1};
        } 
        
        int[] ans = new int[2];

        int nextN = len / 2;
        //1사분면
        int[] r = compress(nextN, y, x+nextN, arr);
        ans[0]+=r[0];
        ans[1]+=r[1];
         //2사분면
        r = compress(nextN, y, x, arr);
        ans[0]+=r[0];
        ans[1]+=r[1];
        //3사분면
        r = compress(nextN, y+nextN, x, arr);
        ans[0]+=r[0];
        ans[1]+=r[1];
        //4사분면
        r = compress(nextN, y+nextN, x+nextN, arr);
        ans[0]+=r[0];
        ans[1]+=r[1];
        
        
        return ans;
    }
    
    void print(int[][] arr){
        System.out.println(" ");

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");

    }
    
}