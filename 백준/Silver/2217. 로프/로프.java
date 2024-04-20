import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr =  new int[n];

        for(int i=0; i<n; i++){
            int next = Integer.parseInt(br.readLine());
            arr[i] = next;
        }

        sol(n,arr);
    }

    private static void sol(int n, int[] arr) {

        Arrays.sort(arr);

        long max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int cnt = arr.length - i;
            int next = arr[i];

            if((long)next * cnt > max) max = (long) next * cnt;
        }

        System.out.println(max);

    }

}
