import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Command{
		int targetX;
		int targetY;
		String dir;
		
		int defenseX;
		int defenseY;
		
		public Command(int targetX, int targetY, String dir, int defenseX, int defenseY) {
			this.targetX = targetX;
			this.targetY = targetY;
			this.dir = dir;
			this.defenseX = defenseX;
			this.defenseY = defenseY;
		}
		public Command(int targetX, int targetY, String dir) {
			
			this.targetX = targetX;
			this.targetY = targetY;
			this.dir = dir;

		}
		@Override
		public String toString() {
			return "Command [targetX=" + targetX + ", targetY=" + targetY + ", dir=" + dir + ", defenseX=" + defenseX
					+ ", defenseY=" + defenseY + "]";
		}
		
		
	}

	static int n;
	static int m;
	static int k;
	
	static int[][] arr;
	static Queue<Command> commands;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		arr = new int[n+1][m+1];
		commands = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<m; j++) {
				
				arr[i+1][j+1] = Integer.valueOf(tk.nextToken());
				
			}
		}
		
		for(int i=0; i<k; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			
			int targetX = Integer.valueOf(tk.nextToken());
			int targetY = Integer.valueOf(tk.nextToken());
			String dir = tk.nextToken();
			
			tk = new StringTokenizer(br.readLine()," ");

			int defenseX = Integer.valueOf(tk.nextToken());
			int defenseY = Integer.valueOf(tk.nextToken());
			
			Command c = new Command(targetX, targetY, dir, defenseX, defenseY);
			commands.add(c);
		}
		
		int cnt = 0;
		
		while(!commands.isEmpty()) {
			Command cmd = commands.poll();
			
			if(!isAlreadyFallen(cmd)) {
				
	
				cnt+=fallRecursively(cmd);
				
				
			}
			
			
			restoreFallenOne(cmd);
	
		}

		System.out.println(cnt);
		
		print();

	}
	
	private static void print() {
		
		for(int i=1; i<arr.length; i++) {
			String t ="";
			for(int j=1; j<arr[i].length; j++) {
				t+= arr[i][j]>0?"S":"F";
				t+=" ";
			}
			System.out.println(t.substring(0,t.length()-1));
		}
		
	}
	private static int fallRecursively(Command cmd) {

		String dir = cmd.dir;
		int x = cmd.targetX;
		int y = cmd.targetY;
		
		if(x < 0 || y < 0 || x > n || y > m) return 0;
		
		int length = arr[x][y];
		
		if(length < 0) return 0;
		

		arr[x][y] *= -1;
		
		
		int cnt = 0;
		
		if(length > 1) {
		
			if(dir.equals("E")) {
			
				for(int i=y; i<y+length-1 && i<m; i++) {
					cnt+=fallRecursively(new Command(x,i+1,dir));
				}
			}
			
			if(dir.equals("W")) {
				for(int i=y; i>y-length+1 && i>=0; i--) {
					cnt+=fallRecursively(new Command(x,i-1,dir));
				}
			}
			
			if(dir.equals("S")) {
				for(int i=x; i<x+length-1 && i<n; i++) {
					cnt+=fallRecursively(new Command(i+1,y,dir));
				}
			}
	
			if(dir.equals("N")) {
				for(int i=x; i>=0 && i>x-length+1; i--) {
					cnt+=fallRecursively(new Command(i-1,y,dir));
				}
			}
		}
		
		cnt++;

		return cnt;
	}
	private static void restoreFallenOne(Command cmd) {
		if(arr[cmd.defenseX][cmd.defenseY] < 0) arr[cmd.defenseX][cmd.defenseY] *= -1;
	}
	private static boolean isAlreadyFallen(Command cmd) {
		
		if(arr[cmd.targetX][cmd.targetY] <0 ) return true;
		
		return false;
	}
}
