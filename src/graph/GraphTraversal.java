package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * BFS && DFS
 */
public class GraphTraversal {

    ListGraph graph;
    boolean[] visited;

    public GraphTraversal(ListGraph listGraph){
        this.graph=listGraph;
        visited=new boolean[listGraph.graphs.size()];
    }

    public void DFS(){
        for(int i=0;i<graph.graphs.size();i++){
            if(!visited[i]){
                DFSTraversal(i);
            }
        }
    }

    private void DFSTraversal(int v) {
        if(visited[v]) return;
        visited[v]=true;
        System.out.print(v+"->");
        Iterator<Integer> neighbors=graph.graphs.get(v).iterator();
        while(neighbors.hasNext()){
            int nextNode=neighbors.next();
            if(!visited[nextNode]){
                DFSTraversal(nextNode);
            }
        }
    }

    public void BFS(){
        for(int i=0;i<graph.graphs.size();i++){
            if(!visited[i]){
                BFSTraversal(i);
            }
        }
    }

    private void BFSTraversal(int v) {
        Deque<Integer> queue=new ArrayDeque<>();
        visited[v]=true;
        queue.offerFirst(v);
        while(!queue.isEmpty()){
            Integer cur=queue.removeFirst();
            System.out.println(cur+"->");
            Iterator<Integer> neighbors=graph.graphs.get(cur).iterator();
            while(neighbors.hasNext()){
                int nextNode=neighbors.next();
                if(!visited[nextNode]){
                    queue.offerLast(nextNode);
                    visited[nextNode]=true;
                }
            }
        }
    }
}
