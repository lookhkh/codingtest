
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int cnt = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<=nodes; i++) list.add(new ArrayList<>());

        for(int i=0; i<edges; i++){

            String[] split = br.readLine().split(" ");

            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);

            list.get(from).add(to);
            list.get(to).add(from);

        }

        sol(1, list);


    }

    private static void sol(int start, List<List<Integer>> list) {

        boolean[] path = new boolean[list.size()];
        dfs(start, path, list);
        System.out.println(cnt);
    }
    private static void dfs(int start, boolean[] path, List<List<Integer>> list) {
        if(path[start]) return;
        path[start] = true;
        cnt++;
        List<Integer> integers = list.get(start);

        for(int next : integers){
            dfs(next, path, list);
        }
    }
}