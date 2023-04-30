import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] map;
    static int N;
    static int M;
    //상하좌우 
    static int[] rowD = new int[] {-1,1,0,0};
    static int[] colD = new int[] {0,0,-1,1};
    
    
    
    static class Point{
        int x,y;
        boolean hasDestroyed;
       
        public Point(int x, int y) {

            this.x = x;
            this.y = y;
            this.hasDestroyed = false;
        }

        public Point(int x, int y, boolean hasDestroyed) {
            this.x = x;
            this.y = y;
            this.hasDestroyed = hasDestroyed;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", hasDestroyed=" + hasDestroyed + "]";
        }

    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk =new StringTokenizer(br.readLine()," ");
        
        N = Integer.valueOf(tk.nextToken());
        M = Integer.valueOf(tk.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            
            String str = br.readLine();
            
            for(int j=0; j<str.length(); j++) {
                
                map[i][j] = Integer.valueOf(str.charAt(j)-'0');
                
            }
        }
        
        bfs(new Point(0,0));
                
    }

    private static void bfs(Point startPoint) {

        Queue<Point> que = new LinkedList<>();
        boolean[][][] ch = new boolean[2][N][M];
        
        // 0 부순 적이 없다 . 1 부순 적이 있다.
        
        
        que.add(startPoint);
        
        int cnt = 1;
        while(!que.isEmpty()) {
            
            int size = que.size();
            
            for(int i=0;i<size; i++) {
                
                Point node = que.poll();
               
                if(ch[node.hasDestroyed?1:0][node.x][node.y]) continue;
               
                ch[node.hasDestroyed?1:0][node.x][node.y] = true;
                
                if(node.x==N-1 && node.y == M-1) {
                    
                    System.out.println(cnt);
                    return;
                    
                }
                
                for(int j=0; j<4; j++) {                    
                    
                    int nextR = node.x+rowD[j];
                    int nextC = node.y+colD[j];
                    
                    if(nextR>=0 && nextC >=0 && nextR<N && nextC <M) {
                        
                        if(map[nextR][nextC] == 1) {
                            
                            if(ch[1][nextR][nextC] || node.hasDestroyed ) continue;
                            if(!ch[1][nextR][nextC] && !node.hasDestroyed) {
                             
                                que.add( new Point(nextR,nextC,!node.hasDestroyed));
                                
                            }
                            
                        }else {
                            
                            if(ch[node.hasDestroyed?1:0][nextR][nextC]) continue;
                            que.add(new Point(nextR,nextC,node.hasDestroyed));
                            
                        }

                     
                        
                    }
                    
                }
                                
            }
            
            cnt++;

        }
        System.out.println(-1);
    }

      
}