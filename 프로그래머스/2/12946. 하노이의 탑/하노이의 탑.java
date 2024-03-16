import java.util.*;
class Solution {
    List<int[]> ans = new ArrayList<>();
    public List<int[]> solution(int n) {
        int[][] answer = {};
        move(n, 1, 2, 3);
        return ans;
    }
    
    void move(int n, int source ,int middle, int des){
        if(n == 1) ans.add(new int[]{source, des});
        else{
            move(n-1, source, des, middle);
            ans.add(new int[]{source, des});
            move(n-1, middle, source, des);
        }
    }
}