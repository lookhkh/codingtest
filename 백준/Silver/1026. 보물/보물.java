import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sol(n, a, b);
    }

    private static void sol(int n, int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {

            int aVal = a[i];
            int bVal = b[b.length-1-i];
            sum+= aVal * bVal;


        }

        System.out.println(sum);

    }

}
