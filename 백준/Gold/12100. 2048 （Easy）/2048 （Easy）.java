
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Main {

    static int[] nx = new int[]{-1,1,0,0};
    static int[] ny = new int[]{0,0,-1,1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = s;
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for(int x=0; x<4; x++){
                    for(int y=0; y<4; y++){
                        for(int z=0; z<4; z++){
                            int[][] mock = create(arr);
                            move(mock, i);
                            move(mock, j);
                            move(mock, x);
                            move(mock, y);
                            move(mock, z);

                            max = Math.max(max, findMax(mock));

                        }

                    }
                }
            }
        }

        System.out.println(max);

    }

    private static int findMax(int[][] mock) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : mock) {
            for (int n : ints) {
                max = Math.max(n, max);
            }
        }
        return max;
    }

    private static int[][] create(int[][] arr) {
        int[][] a = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                a[i][i1] = arr[i][i1];
            }
        }

        return a;
    }

    private static void move(int[][] arr, int mode) {

        boolean[][] his = new boolean[arr.length][arr.length];
        if(mode == 0){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    handle(arr, mode, i, j, his);
                }
            }
        }else if(mode == 1){
            for (int i = arr.length-1; i>=0; i--) {
                for (int j = 0; j < arr[i].length; j++) {
                    handle(arr, mode, i, j, his);
                }
            }
        }else if(mode == 2){
            for (int i = arr.length-1; i>=0; i--) {
                for (int j = 0; j < arr[i].length; j++) {
                    handle(arr, mode, i, j, his);
                }
            }
        }else{
            for (int i = arr.length-1; i>=0; i--) {
                for (int j = arr[i].length-1; j>=0; j--) {
                    handle(arr, mode, i, j, his);
                }
            }
        }

    }

    private static void handle(int[][] arr, int mode, int i, int j, boolean[][] his) {
        if(arr[i][j] > 0){
            int x = i;
            int y = j;
            Stack<int[]> stack = new Stack<>();
            while(true){

                x+=nx[mode];
                y+=ny[mode];

                if(x < 0|| y<0 || x>= arr.length || y >= arr.length){
                    doFromStack(arr, stack, i, j);
                    break;
                }

                if(arr[x][y] == 0) {
                    stack.push(new int[]{x,y});
                    continue;
                }else if(arr[x][y] != arr[i][j]){
                    doFromStack(arr, stack, i, j);
                }else{
                    if(his[x][y]){
                        doFromStack(arr, stack, i, j);
                    }
                    else {
                        his[x][y] = true;
                        arr[x][y] = arr[x][y] * 2;
                        arr[i][j] = 0;
                    }
                }

                break;

            }

        }
    }

    private static void doFromStack(int[][] arr, Stack<int[]> stack, int i, int j) {
        if(!stack.isEmpty()){
            int[] lastPoint = stack.pop();
            arr[lastPoint[0]][lastPoint[1]] = arr[i][j];
            arr[i][j] = 0;
        }
    }

}
