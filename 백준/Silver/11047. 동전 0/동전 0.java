import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            int i1 = Integer.parseInt(br.readLine());
            coins[i] = i1;
        }

        sol(n,k,coins);


    }

    private static void sol(int n, int k, int[] coins) {

        int cnt = 0;

        while(k > 0){

            for(int i=coins.length-1; i>=0; i--){
                int coin = coins[i];
                while(coin <= k){
                    cnt++;
                    k-=coin;
                }
            }

        }

        System.out.println(cnt);

    }
}
