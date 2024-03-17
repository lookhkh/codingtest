/**
1. 1, 2, 3, 4, 5, 1, 2, 3, 4, 5
2. 2, 1, 2, 3, 2, 4, 2, 5
3. 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

**/
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = 0;
        
        int max = 0;
        int firstAns = 0;
        int secondAns = 0;
        int thirdAns = 0;
        
        for(int i=0; i<answers.length; i++){
            int ans = answers[i];
            firstAns += check(first, firstIdx, ans);
            secondAns += check(second, secondIdx, ans);
            thirdAns += check(third, thirdIdx, ans);
            
            max = Integer.max(Integer.max(firstAns,secondAns),thirdAns);
            
            firstIdx = checkIdx(first, firstIdx+1);
            secondIdx = checkIdx(second, secondIdx+1);
            thirdIdx = checkIdx(third, thirdIdx+1);

        }
        
        List<Integer> list = new ArrayList<>();
        if(firstAns == max) list.add(1);
        if(secondAns == max) list.add(2);
        if(thirdAns == max) list.add(3);
        
        
        return list.stream().mapToInt(Integer::new).toArray();
    }
    
    int checkIdx(int[] arr, int idx){
        
        if(idx == arr.length) return 0;
        return idx;
    }
    int check(int[] arr, int idx, int ans){
        int arrVal = arr[idx];
        return arrVal == ans ? 1 : 0;
    }
}