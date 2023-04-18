//https://www.acmicpc.net/problem/10994

package D0418;

import java.util.Arrays;
import java.util.Scanner;

public class Main10994 {
	
	static int n;
	static char[][] map;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		
		int col = getCol(n);
		int row = getRow(col);
		
		map = new char[row][col];
		
		for(char[] w : map) {
			Arrays.fill(w, ' ');
		}
		
		dfs(n, 0, 0);
		
		print();
		
	}
	private static int getRow(int col) {
		return col ;
	}
	private static int getCol(int n) {
		return 4 * (n-1)+1;
	}
	private static void dfs(int idx, int startX ,int startY) {
		if(idx == 1) {
			map[startX][startY] = '*';
		}else {
			int endY = getCol(idx)+startY;
			int endX = getRow(endY);
			
			for(int i=startY; i<endY; i++ ) {
				map[startX][i] = '*';
			}
			
			for(int i=startY; i<endY; i++ ) {
				map[endX-1][i] = '*';
			}
			
			for(int i=startX; i<endX; i+=1) {
				map[i][startY] = '*';
			}
			
			for(int i=startX; i<endX; i+=1) {
				map[i][endY-1] = '*';
			}
			
			dfs(idx-1,startX+2, startY+2);
		}
		
		
	}
	private static void print() {
		for(char[] w : map) {
			StringBuilder b= new StringBuilder();
			for(char v : w) {
				b.append(v);
			}
			System.out.println(b.toString());
		}
	}
}
