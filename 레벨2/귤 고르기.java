//https://school.programmers.co.kr/learn/courses/30/lessons/138476


import java.lang.Comparable;
import java.util.Arrays;

class Solution {
    
    int[] nums;
    static class Num implements Comparable<Num>{
        int idx;
        int nums;
        
        public Num(int idx ,int nums){
            this.idx = idx;
            this.nums = nums;
        }
        
        @Override
        public int compareTo(Num n1){
            int result =  n1.nums - this.nums;
            return result;
        }
        
        @Override
        public String toString(){
            return this.idx+"   "+this.nums;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int length = 10_000_001;
        nums = new int[length];
        
        for(int t : tangerine ){
            nums[t]+=1;
        }
        
        Num[] objs = new Num[length];
        Arrays.fill(objs,new Num(0,0));
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(n <= 0) continue;

            Num num = new Num(i,n);
            objs[cnt++] = num;
        }
        
 
       Arrays.sort(objs);
        
        
//             for(Num t : objs){
//             System.out.println(t);
//         }
        
        int idx = 0;
        while(k>0){
            
            Num n = objs[idx++];
            k -= n.nums;
            
        }
        
        return idx;
    }
}