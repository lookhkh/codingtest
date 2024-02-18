
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<List<Integer>> graph = new ArrayList<>();

        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int e = Integer.parseInt(split[1]);
        int start = Integer.parseInt(split[2]);

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);

        }

        for(List<Integer> next : graph) next.sort(null);
        sol(start, graph);

    }

    private static void sol(int start, List<List<Integer>> graph) {

        dfs(start, graph);
        bfs(start, graph);
    }

    private static void bfs(int start, List<List<Integer>> graph) {
        StringBuilder b = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();

        boolean[] path = new boolean[graph.size()];
        que.add(start);

        while(!que.isEmpty()){

            int next = que.poll();
            if(path[next]) continue;;
            path[next] = true;

            b.append(next+" ");

            List<Integer> adjacent = graph.get(next);

            for(int nextOne : adjacent){

                if(path[nextOne]) continue;
                que.add(nextOne);

            }

        }

        System.out.println(b.substring(0, b.length()-1));

    }

    private static void dfs(int start, List<List<Integer>> graph) {

        boolean[] path = new boolean[graph.size()+1];
        StringBuilder b = new StringBuilder();
        dfs(start, path, graph, b);
        System.out.println(b.substring(0, b.length()-1));
    }

    private static void dfs(int start, boolean[] path, List<List<Integer>> graph, StringBuilder b) {

        path[start] = true;
        List<Integer> adjacent = graph.get(start);
        b.append(start+" ");
        for(int next : adjacent){
            if(path[next]) continue;;
            dfs(next, path, graph,b);
        }
    }

}