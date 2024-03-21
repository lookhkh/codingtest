import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int[] first = dots[0];
        int[] second = dots[1];
        int[] third = dots[2];
        int[] forth = dots[3];
        
        if(calc(first[0],first[1], second[0],second[1]) == calc(third[0],third[1],forth[0],forth[1])) return 1;
        if(calc(first[0],first[1], third[0],third[1]) == calc(second[0],second[1],forth[0],forth[1])) return 1;
        if(calc(first[0],first[1], forth[0],forth[1]) == calc(second[0],second[1],third[0],third[1])) return 1;


        return 0;
    }
    
    double calc(int x1, int y1, int x2, int y2){
        
        return (double)(y2-y1) / (x2-x1);
        
    }
}