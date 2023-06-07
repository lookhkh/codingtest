import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static class Party{
        int participantNum;
        List<Integer> list;
        
        public Party(int participantNum) {
            super();
            this.participantNum = participantNum;
            this.list = new ArrayList<>();
        }
        
        public void add(int participant) {
            this.list.add(participant);
        }
        
        
    }
    
    static int N;
    static int M;
    
    static int[] people;
    static boolean[] whoKnows;
    static Party[] parties;

    static List<Set<Integer>> graph = new ArrayList<>();
    
   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer tk = new StringTokenizer(br.readLine()," ");
       
       N = Integer.valueOf(tk.nextToken());
       M = Integer.valueOf(tk.nextToken());
       
       people = new int[N+1];
       
       
       for(int i=0; i<people.length; i++) {
           people[i] = i;
       }
       
       for(int i=0; i<people.length; i++) {
           graph.add(new HashSet<>());
       }
       
       parties = new Party[M];
       whoKnows = new boolean[N+1];
       
       tk = new StringTokenizer(br.readLine()," ");
       
       int whoKnowNums = Integer.valueOf(tk.nextToken());
       
       for(int i=0; i<whoKnowNums; i++) {
           
           int whoKnow = Integer.valueOf(tk.nextToken());
           whoKnows[whoKnow] = true;
           
       }
       
       for(int i=0; i<parties.length; i++) {
           
           tk = new StringTokenizer(br.readLine()," ");
           
           int nums = Integer.valueOf(tk.nextToken());
          
           parties[i] = new Party(nums);

           for(int j=0; j<nums; j++) {
               
               parties[i].add(Integer.valueOf(tk.nextToken()));
           }
           
       }
       
       for(int i=0;i<parties.length; i++) {
           
           Party party = parties[i];
           
           List<Integer> particpients = party.list;
           
           for(int j=0; j<particpients.size()-1; j++) {
               
               int from = particpients.get(j);
               
               for(int z=j+1; z<particpients.size(); z++) {
               
                   int to = particpients.get(z);
                   
                   graph.get(from).add(to);
                   graph.get(to).add(from);
                   
               }
           }
           
       }
       
       
       for(int i=0; i<people.length; i++) {
           if(whoKnows[i]) continue;
           bfs(people[i]);
       }
 
       int cnt = 0;
       
       for(int i=0; i<parties.length; i++) {
           
           Party p = parties[i];
           List<Integer> participents =  p.list;
           boolean result = true;
           for(int j=0; j<participents.size(); j++) {
               
               if(whoKnows[participents.get(j)]) {
                   result = false;
                   break;
               }
               
           }
           
           if(result) cnt++;
           
       }
       
       System.out.println(cnt);
       
   }

    private static void bfs(int start) {
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] ch = new boolean[people.length+1];
        
        que.add(start);
        
        while(!que.isEmpty()) {
            
            int node = que.poll();
            if(ch[node]) continue;
            ch[node] = true;
            
            if(whoKnows[node]) {
                whoKnows[start] = true;
                break;
            }
            
            Set<Integer> links = graph.get(node);
            
            for(int link : links) {
                
                if(ch[link]) continue;
                
                que.add(link);
                
            }
            
        }
        
    }              
}