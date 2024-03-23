import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int tIdx = 0;
        int t = 0;
        int weightSum = 0;
        Queue<Truck> que = new LinkedList<>();
        
        while(true){
            if(tIdx == truck_weights.length && que.isEmpty()) return t;
            
            t++;
            
            if(!que.isEmpty()){
                Truck head = que.peek();
                if(t - head.time == bridge_length){
                    Truck h = que.poll();
                    weightSum -= h.weight;
                }
            }
            
            if(tIdx < truck_weights.length){
                int curWeight = truck_weights[tIdx++];
                weightSum += curWeight;

                if(weightSum > weight) {
                    weightSum -= curWeight;
                    tIdx--;
                    continue;
                }

                Truck nt = new Truck(t, curWeight);
                que.add(nt);
            }
            
        }
    }
}
class Truck{
    int weight;
    int time;
    Truck(int time, int weight){
        this.time = time;
        this.weight = weight;
    }
}