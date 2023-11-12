import java.util.Scanner;
import java.lang.StringBuilder;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder n = new StringBuilder();

        for(int i=0; i<b; i++){
            for(int j=0; j<a; j++){
                n.append("*");
            }
            n.append("\n");
        }

        System.out.println(n.toString());
    }
}