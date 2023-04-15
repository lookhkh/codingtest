//https://www.acmicpc.net/problem/11663


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		int[][] lines = new int[m][2];
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			lines[i][0] = Integer.valueOf(tk.nextToken());
			lines[i][1] = Integer.valueOf(tk.nextToken());
            Arrays.sort(lines[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<lines.length; i++) {
			
			int[] line = lines[i];

			int rightIdx = findRightIdx(line[1],arr);
			int leftIdx = findLeftIdx(line[0], arr);
			
			if(rightIdx == -1 || leftIdx == -1) System.out.println(0);
			else System.out.println(rightIdx- leftIdx+1);
			
		}
	}

	private static int findLeftIdx(int iimit, int[] arr) {

		int left = 0;
		int right = arr.length-1;
		int answer = -1;
		while(left<=right) {
			
			int mid = ( left + right )/ 2;
			int value = arr[mid];
			
			if(value >= iimit) {
				right = mid-1;
				answer = mid;
			}else {
				left = mid+1;
			}
			
		}
		
		return answer;	}

	private static int findRightIdx(int limit, int[] arr) {


		int left = 0;
		int right = arr.length-1;
		int answer = -1;
		while(left<=right) {
			
			int mid = ( left + right )/ 2;
			int value = arr[mid];
			
			if(value <= limit) {
				left = mid+1;
				answer = mid;
			}else {
				right = mid-1;
			}
			
		}
		
		return answer;
	}

}