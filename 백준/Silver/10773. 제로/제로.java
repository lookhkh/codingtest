import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> list = new Stack<>();

        for (int i = 0; i < k; i++) {
            int e = Integer.parseInt(br.readLine());
            if(e == 0) list.pop();
            else list.push(e);
        }

        int result = 0;

        while(!list.isEmpty()) result+=list.pop();

        System.out.println(result);


    }

}