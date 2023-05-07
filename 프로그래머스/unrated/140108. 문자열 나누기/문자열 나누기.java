class Solution {
    public int solution(String s) {
        int count = 0;
        int left=0, right=0;
        int n = s.length();
        while(right<n){
            char c = s.charAt(right);
            int cCount = 1;
            int otherCount = 0;
            while(right+1<n && cCount != otherCount){
                right++;
                if(s.charAt(right) == c) cCount++;
                else otherCount++;
            }
            count++;
            right++;
            left=right;
        }
        return count;
    }
}