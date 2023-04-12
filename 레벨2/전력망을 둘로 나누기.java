//https://school.programmers.co.kr/learn/courses/30/lessons/86971
import java.util.List;
import java.util.ArrayList;

import java.util.Queue;

import java.util.LinkedList;

class Solution {
    
    List<List<Integer>> graph;
    int wholeN;
    int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {

        graph = new ArrayList<>();
        wholeN = n;
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] wire : wires){
            
            int from = wire[0];
            int to = wire[1];
            
            graph.get(from).add(to);
            graph.get(to).add(from);
            
        }
        
        for(int i=0; i<wires.length; i++){
            
            int from = wires[i][0];
            int to = wires[i][1];

            int resultOfFrom = bfs(from,to);
            int others = n - resultOfFrom;
            
            int finalResult = Math.abs(resultOfFrom - others);
            
            min = Math.min(finalResult, min);        
        }
        
        
        return min;
    }
    
    public int bfs(int start, int notGo){
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] ch = new boolean[wholeN+1];
        
        que.add(start);
        int cnt = 0;
        while(!que.isEmpty()){
            
            int next = que.poll();
            if(next == notGo) continue;
            if(ch[next]) continue;
            ch[next] = true;
            cnt++;
            List<Integer> subTree = graph.get(next);
            
            for(int node : subTree){
                
                que.add(node);
                
            }
            
            
        }
        
        
        return cnt;
        
    }
}