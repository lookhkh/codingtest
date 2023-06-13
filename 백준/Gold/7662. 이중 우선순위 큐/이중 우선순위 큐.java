import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
   static class DualPriorityQueue{
      
       Map<Integer,Integer> status = new HashMap<>();
       
       PriorityQueue<Integer> maxDeleteQue = new PriorityQueue<Integer>((a,v)->-(a-v));
       PriorityQueue<Integer> minimumDeleteQue = new PriorityQueue<Integer>((a,v)->a-v);
   
       public void insert(int num) {
           
           maxDeleteQue.add(num);
           minimumDeleteQue.add(num);
           
           status.put(num, status.getOrDefault(num, 0)+1);
           
       }
       
       public void delete(int type) {
         
           
           if(type < 0 && !minimumDeleteQue.isEmpty()) {
               int minimum = minimumDeleteQue.poll();
               if(status.getOrDefault(minimum, 0)>0) {
                   status.put(minimum, status.get(minimum)-1);
               }else {
                   delete(-1);
               }
           }
           
           if(type > 0 && !maxDeleteQue.isEmpty()) {
               int maximum = maxDeleteQue.poll();
               if(status.getOrDefault(maximum, 0)>0) {
                   status.put(maximum, status.get(maximum)-1);
               }else {
                   delete(1);
               }
               
           }
           
       }
       
       public void cardOnTheTable() {
           
          Iterator<Integer> keys =  status.keySet().iterator();          

          int max = Integer.MIN_VALUE;
          int min = Integer.MAX_VALUE;
          
          while(keys.hasNext()) {
              
              int t = keys.next();
              if(status.getOrDefault(t, 0)>0 &&  t > max ) max = t;
              if(status.getOrDefault(t, 0)>0 && t < min) min = t;
              
          }
          
          
          if(max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) System.out.println("EMPTY");
          else System.out.println(max+" "+min);
          
          status = new HashMap<Integer, Integer>();
          maxDeleteQue = new PriorityQueue<Integer>((a,v)->-(a-v));
          minimumDeleteQue = new PriorityQueue<Integer>((a,v)->a-v);
       }
       
    
       
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
   
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       DualPriorityQueue que = new DualPriorityQueue();
       
       int first =Integer.valueOf(br.readLine());
       
       for(int i=0; i<first;i++) {
           
           int second = Integer.valueOf(br.readLine());
           
           for(int j=0; j<second; j++) {
               
               StringTokenizer tk = new StringTokenizer(br.readLine()," ");
               
               String command = tk.nextToken();
               int nums = Integer.valueOf(tk.nextToken());
               
               if(command.equals("I")) {
                   que.insert(nums);
               }else {
                   que.delete(nums);
               }
               
           }
           que.cardOnTheTable();
       }
       
       
       
       
   }

   
}