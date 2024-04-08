class Solution {
    int max = Integer.MIN_VALUE;
    int[] arr = null;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        for(int i=1; i<=n; i++){
            int cur = 0;
            boolean[] his = new boolean[11];
            int idx = 0;
            picks(i,n, info, cur, idx, his);
            
        }
        return arr == null? new int[]{-1} : arr;
    }
    
    void picks(int cnt, int n, int[] info, int cur, int idx,  boolean[] path){
        if(cur == cnt){
            int[] rionArr = new int[11];
            int pathCnt = 0;
            for(int i=0; i<path.length; i++){
                if(path[i]){
                    pathCnt ++;
                    if(n < info[i]) return;
                    n-= (info[i]+1);
                    rionArr[i] = info[i]+1;
                }
            }
            
            
            if(n < 0) return;
            
            int apache = 0;
            int rion = 0;
            for(int i=0; i<path.length; i++){
                if(path[i]) rion+= 10 - i;
                else if(info[i] > 0) apache += 10-i;
            }
            
            if(n > 0){
              rionArr[10] += n;
            }
            
            int result = rion - apache;
            if(result <= 0) return;
            
            if(max > result) return;
            if(result > max) {
                max = result;
                arr = rionArr;
            }
            if(result == max){
                
                for(int i=arr.length-1; i>=0; i--){
                    if(arr[i] - rionArr[i] > 0) return;
                    else {
                        arr = rionArr;
                        return;
                    }
                }
                
            }
            
        }else{
            
            for(int i=idx; i<path.length; i++){
                if(path[i]) continue;
                path[i] = true;
                picks(cnt,n, info, cur+1, i+1, path);
                path[i] = false;
            }
            
        }
    }
}