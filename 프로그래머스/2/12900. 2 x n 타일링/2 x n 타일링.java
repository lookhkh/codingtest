class Solution {
    int nanu = 1000000007;
    public int solution(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        
        if(n <=3) return ans[n];
        
        for(int i=4; i<=n; i++){
            ans[i] = ans[i-1] % 1000000007 + ans[i-2] % 1000000007;
        }
        
        return ans[n] % 1000000007;
    }
}