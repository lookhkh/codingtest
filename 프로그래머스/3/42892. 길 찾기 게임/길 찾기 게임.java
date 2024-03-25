/**
1. 주어진 노드 정보에서, y축을 기점으로 작은 순으로 정렬한다.
2. 동일한 y축 값을 가지고 있는 노드에 대해서는, x축을 기점으로 정렬한다.
3. nodeinfo에 저장된 순서대로, 노드는 번호를 매긴다.
**/
import java.util.*;
class Solution {
    public List<List<Integer>> solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        List<Node> lists = new ArrayList<>();    
        for(int i=0; i<nodeinfo.length; i++){
            int[] next = nodeinfo[i];
            lists.add(new Node(i+1,next[0], next[1]));
        }
        
        lists.sort((t1,t2)->{
            if(t1.y != t2.y) return Integer.compare(t2.y,t1.y);
            return Integer.compare(t1.x,t2.x);
        });
        
        Tree tree = new Tree(lists.get(0));
        
        for(int i=1; i<lists.size(); i++){
            tree.insert(tree.parent, lists.get(i));
        }
        
        // lists.forEach(t->System.out.println(t.idx+" "+t.y+" "+t.x));
        
        List<Integer> preorder = new ArrayList<>();
        preorder(tree.parent,preorder);

        List<Integer> postOrder = new ArrayList<>();
        postOrder(tree.parent,postOrder);

        return Arrays.asList(preorder, postOrder);
    }
    
    void preorder(Node n, List<Integer> history){
        if(n == null) return;
        history.add(n.idx);
        preorder(n.left, history);
        preorder(n.right, history);
        
    }
    
      void postOrder(Node n, List<Integer> history){
        if(n == null) return;
        postOrder(n.left, history);
        postOrder(n.right, history);
        history.add(n.idx);
        
    }
}

class Tree{
    Node parent;
    
    Tree(Node root){
        this.parent = root;
    }
    
    void insert(Node parent,Node child){
       if(parent.x > child.x){
           if(parent.left == null){
               parent.left = child;
           }else insert(parent.left, child);
       }else{
           if(parent.right == null){
               parent.right = child;
           }else{
               insert(parent.right, child);
           }
       }
    
    }
}


class Node{
    int idx;
    int x;
    int y;
    public Node left;
    public Node right;
    
    Node(int idx, int x, int y){
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
    

}