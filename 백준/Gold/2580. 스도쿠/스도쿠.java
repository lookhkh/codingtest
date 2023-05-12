import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");

			for(int j=0; j<9; j++) {
				
				map[i][j] = Integer.valueOf(tk.nextToken());
				
			}
		}
		
		backtracking(0,0);
	
		
	}

	private static void backtracking(int row, int col) {

		if(col > 8) {
			backtracking(row+1, 0);
			return;
		}else if(row > 8) {			

			printCurrentSudoku();
			System.exit(0);
			
		}else if(map[row][col] != 0) {
			backtracking(row, col+1);
		}else {
			
			for(int i=1; i<=9; i++) {
				
				if(!checkIfSameRowValid(row,col,i)) continue;
				if(!checkIfSameColValid(row,col,i)) continue;
				if(!checkIfSameBoxValid(row,col,i)) continue;
				
				map[row][col] = i;
				backtracking(row,col+1);
				map[row][col] = 0;

			}
			
			
		}
		
		
		
		
	}
	
    private static void printCurrentSudoku() {
        StringBuilder b = new StringBuilder();
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(map[i][j] == 0) {
                    break;
                }else {
                    b.append(map[i][j]+" ");
                }
            }
            
            b.append("\n");
        }
        
        System.out.println(b);
    }

	private static boolean checkIfSameBoxValid(int row, int col, int target) {
		
		int convertRow = (row/3) * 3;
		int convertCol = (col/3) * 3;
		
		for(int i=convertRow; i<convertRow+3; i++) {
			
			for(int j=convertCol; j<convertCol+3; j++) {
				
				if(map[i][j] == target) return false;
				
			}
			
		}
		
		return true;
	}

	private static boolean checkIfSameColValid(int row, int col, int target) {

		for(int i=0; i<9; i++) {
			if(map[i][col] == target) return false;
		}
		
		return true;
	}

	private static boolean checkIfSameRowValid(int row, int col, int target) {
		
		for(int i=0; i<9; i++) {
			if(map[row][i] == target) return false;
		}
		
		return true;
	}
}
