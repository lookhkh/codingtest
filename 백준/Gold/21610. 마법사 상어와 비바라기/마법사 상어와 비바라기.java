import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	

	static int[][] arr;
	static int[][] orders;
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 
	static int[] dirX = new int[] {0,0,-1,-1,-1,0,1,1,1};
	static int[] dirY = new int[] {0,-1,-1,0,1,1,1,0,-1};
	// (위,왼) (위,오) (아래,왼) (아래,오)
	static int[] diagX = new int[] {-1,-1,1,1};
	static int[] diagY = new int[] {-1,1,-1,1};
	
	
	static List<int[]> clouds;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		arr = new int[n+1][n+1];
		orders = new int[m][2];
		clouds = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			
			tk = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=n; j++) {
				
				int next = Integer.valueOf(tk.nextToken());
				
				arr[i][j] = next;
				
			}
			
		}
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine());
			int dir = Integer.valueOf(tk.nextToken());
			int dis = Integer.valueOf(tk.nextToken());
			orders[i][0] = dir;
			orders[i][1] = dis;
			
		}
		
		clouds = initClouds(n);
		
		for(int i=0; i<m; i++) {
			
			int[] order = orders[i];
			
			int dir = order[0];
			int dis = order[1];
			
			moveAllClouds(dir,dis);
			
			changeBucket();

			changeCloud();
			
		}
		
		long sum = getSum();
		
		System.out.println(sum);
		
		
	}
	private static long getSum() {
		long sum = 0;
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				sum+=arr[i][j];
			}
		}
		
		return sum;
	}
	private static void changeCloud() {
		List<int[]> newClud = new ArrayList<>();

		for(int i=1; i<arr.length; i++) {
			
			for(int j=1; j<arr.length; j++) {
				
				if(arr[i][j] < 2) continue;
				
				boolean result = true;
				
				for(int[] cloud : clouds) {
					
					if(cloud[0] == i && cloud[1] == j) {
						
						result = false;
						break;
					}
					
					
				}
				
				if(result) {
					arr[i][j]-=2;
					newClud.add(new int[] {i,j});
				}
				
			}
			
		}
		
		clouds = newClud;
		
	}
	private static void changeBucket() {
		
		for(int[] cloud : clouds) {
			arr[cloud[0]][cloud[1]] +=1;
		}
		
		copyWater();
		
	}
	private static void copyWater() {
				
		for(int[] cloud : clouds) {
			int cnt = 0;
			for(int i=0; i<4; i++) {
				
				int nextX = cloud[0]+diagX[i];
				int nextY = cloud[1]+diagY[i];
				
				if(nextX > 0 && nextX < arr.length && nextY> 0 && nextY < arr.length) {
					
					if(arr[nextX][nextY] > 0) {
						cnt+=1;
					}					
				}
			}
			
			arr[cloud[0]][cloud[1]]+=cnt;
			
		}
		
	}
	private static void moveAllClouds(int dir, int dis) {
		
		for(int i=0; i<clouds.size(); i++) {
			
			int disX = dirX[dir]*dis;
			int disY = dirY[dir]*dis;
			
			int[] next = clouds.get(i);
			int x = next[0];
			int y = next[1];
			
			
			if(disX>0) {
				
				x = getPositionIfPlus(disX, x);
				
			}else if(disX < 0) {
				
				x = getPositionIfMinus(disX, x);
				
			}
			
			
			if(disY>0) y = getPositionIfPlus(disY,y);
			else if(disY < 0) y = getPositionIfMinus(disY, y);
			
			
			
			
			
			next[0] = x;
			next[1] = y;
			
		}
		
	}
	private static int getPositionIfMinus(int disX, int x) {
		for(int w= disX; w<0; w++) {
			x-=1;
			if(x <= 0) x = arr.length-1;
		}
		return x;
	}
	private static int getPositionIfPlus(int disX, int x) {
		for(int w= disX; w>0; w--) {
			
			x+=1;
			if(x >= arr.length) x = 1;
			
		}
		return x;
	}
	
	private static List<int[]> initClouds(int n) {
		
		clouds.add(new int[] {n,1});
		clouds.add(new int[] {n,2});
		clouds.add(new int[] {n-1,1});
		clouds.add(new int[] {n-1,2});
		
		return clouds;
	}
}
