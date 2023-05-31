
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.valueOf(br.readLine());
		
		int[] arr = new int[14];
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<14; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		int[] timing = new int[] {n,0};
		int[] bnp = new int[] {n,0};
		
		executeBnp(bnp,arr);
		executeTiming(timing,arr);
		int timingR = timing[0] + timing[1]*arr[13];
		int bnpR = bnp[0] + bnp[1]*arr[13];
		
		if(timingR > bnpR) System.out.println("TIMING");
		else if(timingR < bnpR) System.out.println("BNP");
		else System.out.println("SAMESAME");

	}

	private static void executeTiming(int[] timing, int[] arr) {
		
		for(int i=0; i<13; i++) {
			int today = arr[i];
			boolean isIncreasing = true;
			boolean isDecreasing = true;
			int j = i+1;
			
			for(; j<arr.length && j<i+3; j++) {
				if(today <= arr[j]) isDecreasing= false;
				if(today >= arr[j]) isIncreasing= false;
				today = arr[j];
			}
			
			if(j == 14) continue;
			
			if(isIncreasing) {
				if(timing[1]!=0) {
					timing[0]+=timing[1] * arr[j];
					timing[1] = 0;
				}
			}
			if(isDecreasing) {
				if(timing[0] > arr[j]) {
					timing[1] += timing[0] / arr[j];
					timing[0] = timing[0] % arr[j];
				}
			}
//			System.out.println(j+"  "+arr[j]+"  "+isIncreasing+"  "+isDecreasing+"  "+timing[0]+"  "+timing[1]);

		}
		
	}

	private static void executeBnp(int[] timing, int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			
			int curPrice = arr[i];
			if(curPrice <= timing[0]) {
				timing[1] += timing[0] / curPrice;
				timing[0] = timing[0]%curPrice;
			}
			
		}
		
	}

}