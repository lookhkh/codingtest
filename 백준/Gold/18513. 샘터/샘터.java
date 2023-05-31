import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Main {
 
    static int N, K, MAX = 100000000;
    static int[] dx = { -1, 1 };
    static Set<Integer> visited;
 
    static class State {
        int x;
        int dist;
 
        public State(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        visited = new HashSet<>();
 
        Queue<State> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            q.add(new State(tmp, 0));
            visited.add(tmp);
        }
        System.out.println(bfs(q));
    }
 
    private static long bfs(Queue<State> q) {
        long res = 0;
        int homeCnt = 0;
        
        out:while(!q.isEmpty()) {
            State now = q.poll();
            for (int d = 0; d < 2; d++) {
                int xx = now.x + dx[d];

                if(visited.contains(xx)) continue;
 
                homeCnt++;
                res += now.dist + 1;
                if(homeCnt == K) break out;
                
                visited.add(xx);
                q.add(new State(xx, now.dist + 1));
            }
        }
        
        return res;
    }
 
}
