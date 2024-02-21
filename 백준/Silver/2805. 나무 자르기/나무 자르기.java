
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static long N;
    static long M;
    static long[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        N = Long.valueOf(tk.nextToken());
        M = Long.valueOf(tk.nextToken());

        arr = new long[(int) N];
        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(tk.nextToken());
        }

        long left = 0L;
        long right = 1_000_000_000L;
        long answer = Long.MIN_VALUE;
        while(left < right){

            long mid = (left + right) / 2;
            long result = check(mid);
            if(result >= M){
                left = mid+1;
                answer = Math.max(answer, mid);
            }else{
                right = mid;
            }

        }

        System.out.println(answer);
    }

    private static long check(long mid) {

        return Arrays.stream(arr)
                .filter(t->t > mid)
                .map(t->t - mid)
                .sum();

    }


}