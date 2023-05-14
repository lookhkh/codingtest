import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    
    static int N;
    static int deletedNode;
    static int rootNode = -1;
    static List<List<Integer>> graph = new ArrayList<>();
    
    static int answer=0;

    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());
        
        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        
        for(int childNode=0; childNode<N; childNode++) {
            
            int parentNode = Integer.valueOf(tk.nextToken());
            
            if(parentNode==-1) {
                rootNode = childNode;
                continue;
            }
            
            graph.get(childNode).add(parentNode);
            graph.get(parentNode).add(childNode);
            
        }
        
        deletedNode = Integer.valueOf(br.readLine());
        if(rootNode == deletedNode) {
            System.out.println(0);
            return;
        }
        
        boolean[] ch = new boolean[N];
        ch[rootNode] = true;

        dfs(rootNode,ch);
        

        System.out.println(answer);
        
    }

    private static void dfs(int startNode, boolean[] ch) {
            
        List<Integer> subGraph = graph.get(startNode);
            
            int wholeLeafs = 0;
            
            for(int next : subGraph) {
                
                if(ch[next] || next==deletedNode) continue;
                ch[next] = true;
                wholeLeafs ++;
                
                dfs(next, ch);
                 
                
            }

            
            if(wholeLeafs == 0) answer++;
            
        
    }
}