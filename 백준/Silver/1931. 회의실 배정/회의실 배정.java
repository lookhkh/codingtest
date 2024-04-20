import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static class Metting implements Comparable<Metting>{
        int start;
        int end;
        int during;
        public Metting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
            this.during = end - start;
        }
        
        @Override
        public int compareTo(Metting o) {
            if(this.end != o.end) {
                return this.end - o.end;
            }else {
                return    o.during - this.during ;
            }
        }

        @Override
        public String toString() {
            return "Metting [start=" + start + ", end=" + end + ", during=" + during + "]";
        }
       
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        
        int n = Integer.valueOf(tk.nextToken());
        
        Metting[] arr = new Metting[n];
        
        for(int i=0; i<n; i++) {
            tk = new StringTokenizer(br.readLine()," ");
            Metting m = new Metting(Integer.valueOf(tk.nextToken()),Integer.valueOf(tk.nextToken()));
            arr[i] = m;
        }
        
        Arrays.sort(arr);
        
        
        Metting lastMetting = null;
        int cnt = 0;
        for(Metting m : arr) {

            if(lastMetting == null) {
                lastMetting = m;
                cnt++;
            }else {
                
                if(m.start >= lastMetting.end) {
                    lastMetting = m;
                    cnt++;
                }
                
            }
            
        }
        
        System.out.println(cnt);
        
        
    }

 
}