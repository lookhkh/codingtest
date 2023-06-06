import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	

	static int n;
	static int m;
	static int k;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		arr = new int[n][m];
		for(int i=0; i<k; i++) {
			
			int[][] next = create(br);
			
			for(int z=0; z<4; z++) {
				
				int[][] t = rotate(next,z);
				boolean result = false;
				
				for(int x=0; x<arr.length; x++) {
					for(int y=0; y<arr[0].length; y++) {
						
						if(write(x,y,t)) {
							result = true;
							break;
						}
						
					}
					if(result) break;

				}
				if(result) break;


			}
		}
		int ans = 0;
		for(int zz =0; zz<arr.length; zz++) {
			for(int yy =0; yy<arr[0].length; yy++) {
				if(arr[zz][yy] == 1) ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	private static void print(int[][] t) {
		for(int zz =0; zz<t.length; zz++) {
			String tt = "";
			for(int yy =0; yy<t[0].length; yy++) {
				tt+=t[zz][yy];
			}
			System.out.println(tt);
		}
	}
	private static boolean write(int x, int y, int[][] t) {
		if(x+t.length-1 >= arr.length) return false;
		if(y+t[0].length-1 >= arr[0].length) return false;
	
		for(int i=x; i<x+t.length; i++) {
			for(int j=y; j<y+t[0].length; j++) {		
				if(arr[i][j] == 1 && t[i-x][j-y] == 1) return false;
			}
		}
		
		for(int i=x; i<x+t.length; i++) {
			for(int j=y; j<y+t[0].length; j++) {
				if(t[i-x][j-y] == 0) continue;
				arr[i][j] = t[i-x][j-y] ;
			}
		}
		
		
		return true;
	}
	private static int[][] create(BufferedReader br) throws IOException {
		StringTokenizer tk;
		tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		int[][] next = new int[n][m];
		for(int z=0; z<n; z++) {
			tk = new StringTokenizer(br.readLine()," ");
			for(int x=0; x<m; x++) {
				next[z][x] = Integer.valueOf(tk.nextToken());
			}
		}
		return next;
	}

	private static int[][] rotate(int[][] next, int z) {
		
		if(z == 0) return next;
		if(z == 1) {
			//rotate input to 90 deg
			return rotate(next);
		}else if(z == 2) {
			//rotate input to 180 deg
			return rotate(rotate(next));
		}else {
			//rotate input to 270 deg
			return rotate(rotate(rotate(next)));

		}
	}
	
	private static int[][] rotate(int[][] next){
		int[][] arr = new int[next[0].length][next.length];
		
		for(int i=0; i<next.length; i++) {
			for(int j=0; j<next[i].length; j++) {
				arr[j][next.length-1-i] = next[i][j];
			}
		};
		
		
		return arr;
	}
}